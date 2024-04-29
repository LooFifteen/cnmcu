/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_elmfer_cnmcu_mcu_NanoMCU */

#ifndef _Included_com_elmfer_cnmcu_mcu_NanoMCU
#define _Included_com_elmfer_cnmcu_mcu_NanoMCU
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    createMCU
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_createMCU
  (JNIEnv *, jclass);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    deleteMCU
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_deleteMCU
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    tick
 * Signature: (J[I[I)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_tick
  (JNIEnv *, jclass, jlong, jintArray, jintArray);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    cycle
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_cycle
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    reset
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_reset
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    setPowered
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_setPowered
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    isPowered
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_isPowered
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    setClockPause
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_setClockPause
  (JNIEnv *, jclass, jlong, jboolean);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    isClockPaused
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_isClockPaused
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    numCycles
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_numCycles
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    setNumCycles
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_setNumCycles
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    busAddress
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_busAddress
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    busData
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_busData
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    busRW
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_busRW
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    CPU
 * Signature: (J)Lcom/elmfer/cnmcu/mcu/cpu/MOS6502;
 */
JNIEXPORT jobject JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_CPU
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    GPIO
 * Signature: (J)Lcom/elmfer/cnmcu/mcu/modules/CNGPIO;
 */
JNIEXPORT jobject JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_GPIO
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    RAM
 * Signature: (J)Lcom/elmfer/cnmcu/mcu/modules/CNRAM;
 */
JNIEXPORT jobject JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_RAM
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_elmfer_cnmcu_mcu_NanoMCU
 * Method:    ROM
 * Signature: (J)Lcom/elmfer/cnmcu/mcu/modules/CNROM;
 */
JNIEXPORT jobject JNICALL Java_com_elmfer_cnmcu_mcu_NanoMCU_ROM
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
