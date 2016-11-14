package com.hone.utils;

import android.graphics.Bitmap;

import java.util.List;
import java.util.Vector;

/**
 * Created by alexweav on 11/14/16.
 */

public class TensorFlowImageClassifier implements Classifier {

    private static final String TAG = "TensorFlowImageClassifier";

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

    @Override
    public List<Recognition> recognizeImage(final Bitmap bitmap) {
        return null;
    }

    @Override
    public void close() {

    }

}
