package com.hone.utils;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by alexweav on 11/14/16.
 */

public class TensorFlowImageClassifier implements Classifier {

    private static final String TAG = "TFImageClassifier";

    private String inputName;
    private String outputName;
    private int inputSize;
    private int imageMean;
    private float imageStd;

    private Vector<String> labels = new Vector<String>();
    private int[] intValues;
    private float[] floatValues;
    private float[] outputs;
    private String[] outputNames;
    private TensorFlowInferenceInterface inferenceInterface;

    public int initializeTensorflow(AssetManager assetManager,
                                    String modelFilename,
                                    String labelFilename,
                                    int numClasses,
                                    int inputSize,
                                    int imageMean,
                                    float imageStd,
                                    String inputName,
                                    String outputName) throws IOException {
        this.inputName = inputName;
        this.outputName = outputName;
        String actualFilename = labelFilename.split("file:///android_asset/")[1];
        Log.i(TAG, "Labels file: " + actualFilename);
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(assetManager.open(actualFilename)));
        String line;
        while ((line = br.readLine()) != null) {
            labels.add(line);
        }
        br.close();
        this.inputSize = inputSize;
        this.imageMean = imageMean;
        this.imageStd = imageStd;
        outputNames = new String[] {outputName};
        intValues = new int[inputSize * inputSize];
        floatValues = new float[inputSize * inputSize * 3];
        outputs = new float[numClasses];
        inferenceInterface = new TensorFlowInferenceInterface();
        return inferenceInterface.initializeTensorFlow(assetManager, modelFilename);
    }

    @Override
    public List<Recognition> recognizeImage(final Bitmap bitmap) {
        //Bitmap is an array of integer values 0-255
        //Convert to a zero-centered normal distribution
        bitmap.getPixels(intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i = 0; i < intValues.length; ++i) {
            final int val = intValues[i];
            floatValues[i * 3 + 0] = (((val >> 16) & 0xFF) - imageMean) / imageStd;
            floatValues[i * 3 + 1] = (((val >> 8) & 0xFF) - imageMean) / imageStd;
            floatValues[i * 3 + 2] = ((val & 0xFF) - imageMean) / imageStd;
        }
        inferenceInterface.fillNodeFloat(inputName, new int[] {1, inputSize, inputSize, 3}, floatValues);
        inferenceInterface.runInference(outputNames);
        inferenceInterface.readNodeFloat(outputName, outputs);
        List<Recognition> recognitions = new ArrayList<Recognition>();
        for (int i = 0; i < outputs.length; ++i) {
            recognitions.add(new Recognition("" + i, labels.get(i), outputs[i], null));
        }
        return recognitions;
    }

    @Override
    public void close() {
        inferenceInterface.close();
    }

}
