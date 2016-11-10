LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

ifeq ($(TARGET_ARCH_ABI),armeabi-v7a)

else

endif

LOCAL_MODULE := tensorflow_inception
LOCAL_ARM_MODE := arm

NDK_MODULE_PATH := $(call my-dir)
include $(BUILD_SHARED_LIBRARY)
