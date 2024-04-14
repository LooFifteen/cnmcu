package com.elmfer.cnmcu.mcu;

import com.elmfer.cnmcu.cpp.StrongNativeObject;
import com.elmfer.cnmcu.mcu.cpu.MOS6502;
import com.elmfer.cnmcu.mcu.modules.CNGPIO;
import com.elmfer.cnmcu.mcu.modules.CNRAM;
import com.elmfer.cnmcu.mcu.modules.CNROM;

public class NanoMCU extends StrongNativeObject {
    public int frontInput, rightInput, backInput, leftInput;
    public int frontOutput, rightOutput, backOutput, leftOutput;

    private int[] inputs = new int[4];
    private int[] outputs = new int[4];

    private MOS6502 cpu;
    private CNGPIO gpio;
    private CNRAM ram;
    private CNROM rom;

    public NanoMCU() {
        setNativePtr(createMCU());

        cpu = CPU(getNativePtr());
        gpio = GPIO(getNativePtr());
        ram = RAM(getNativePtr());
        rom = ROM(getNativePtr());
    }

    public void tick() {
        inputs[0] = frontInput;
        inputs[1] = rightInput;
        inputs[2] = backInput;
        inputs[3] = leftInput;

        tick(getNativePtr(), inputs, outputs);

        frontOutput = outputs[0];
        rightOutput = outputs[1];
        backOutput = outputs[2];
        leftOutput = outputs[3];
    }

    public void cycle() {
        cycle(getNativePtr());
    }

    public void reset() {
        reset(getNativePtr());
    }

    public void setPowered(boolean powered) {
        setPowered(getNativePtr(), powered);
    }

    public boolean isPowered() {
        return isPowered(getNativePtr());
    }

    public void setClockPause(boolean paused) {
        setClockPause(getNativePtr(), paused);
    }

    public boolean isClockPaused() {
        return isClockPaused(getNativePtr());
    }

    public long numCycles() {
        return numCycles(getNativePtr());
    }

    public int busAddress() {
        return busAddress(getNativePtr());
    }

    public int busData() {
        return busData(getNativePtr());
    }

    public boolean busRW() {
        return busRW(getNativePtr());
    }

    public void deleteNative() {
        cpu.invalidateNativeObject();
        gpio.invalidateNativeObject();
        ram.invalidateNativeObject();
        rom.invalidateNativeObject();

        deleteMCU(getNativePtr());
    }

    public MOS6502 getCPU() {
        return cpu;
    }

    public CNGPIO getGPIO() {
        return gpio;
    }

    public CNRAM getRAM() {
        return ram;
    }

    public CNROM getROM() {
        return rom;
    }

    // @formatter:off
    
    /*JNI
        #include "cnmcuJava.h"
        #include "Nano.hpp"
     */ 
    
    private static native long createMCU(); /*
        cnmcuJava::init(env);
        CodeNodeNano* nano = new CodeNodeNano();
        return reinterpret_cast<jlong>(nano);
    */
    
    private static native void deleteMCU(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        delete nano;
    */
    
    private static native void tick(long ptr, int[] inputs, int[] outputs); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        
        uint8_t* pvFront = nano->GPIO().pvFrontData();
        uint8_t dir = *nano->GPIO().dirData();
        bool frontPinIsInput = (dir & 0b0001) == 0;
        bool rightPinIsInput = (dir & 0b0010) == 0;
        bool backPinIsInput  = (dir & 0b0100) == 0;
        bool leftPinIsInput  = (dir & 0b1000) == 0;
        
        pvFront[0] = frontPinIsInput ? static_cast<uint8_t>(inputs[0]) : pvFront[0];
        pvFront[1] = rightPinIsInput ? static_cast<uint8_t>(inputs[1]) : pvFront[1];
        pvFront[2] = backPinIsInput  ? static_cast<uint8_t>(inputs[2]) : pvFront[2];
        pvFront[3] = leftPinIsInput  ? static_cast<uint8_t>(inputs[3]) : pvFront[3];
        
        nano->tick();
        
        outputs[0] = static_cast<jint>(frontPinIsInput ? 0 : pvFront[0]);
        outputs[1] = static_cast<jint>(rightPinIsInput ? 0 : pvFront[1]);
        outputs[2] = static_cast<jint>(backPinIsInput  ? 0 : pvFront[2]);
        outputs[3] = static_cast<jint>(leftPinIsInput  ? 0 : pvFront[3]);
    */
    
    private static native void cycle(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        nano->cycle();
    */
    
    private static native void reset(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        nano->reset();
    */
    
    private static native void setPowered(long ptr, boolean powered); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        if(powered)
            nano->powerOn();
        else
            nano->powerOff();
    */
    
    private static native boolean isPowered(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jboolean>(nano->isPoweredOn());
    */
    private static native void setClockPause(long ptr, boolean paused); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        if(paused)
            nano->pauseClock();
        else
            nano->resumeClock();
    */
    
    private static native boolean isClockPaused(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jboolean>(nano->isClockPaused());
    */
    
    private static native long numCycles(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jlong>(nano->numCycles());
    */
    
    private static native int busAddress(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jint>(nano->busAddress());
    */
    
    private static native int busData(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jint>(nano->busData());
    */
    
    private static native boolean busRW(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        return static_cast<jboolean>(nano->busRw());
    */
    
    private static native MOS6502 CPU(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        mos6502* cpu = &nano->CPU();
        jobject cpuObj = env->NewObject(cnmcuJava::MOS6502, cnmcuJava::MOS6502_init, reinterpret_cast<jlong>(cpu));
        return cpuObj;
    */
    
    private static native CNGPIO GPIO(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        CNGPIO<CodeNodeNano::GPIO_NUM_PINS>* gpio = &nano->GPIO();
        jobject gpioObj = env->NewObject(cnmcuJava::CNGPIO, cnmcuJava::CNGPIO_init, reinterpret_cast<jlong>(gpio));
        return gpioObj;
    */
    
    private static native CNRAM RAM(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        CNRAM<CodeNodeNano::RAM_SIZE>* ram = &nano->RAM();
        jobject ramObj = env->NewObject(cnmcuJava::CNRAM, cnmcuJava::CNRAM_init, reinterpret_cast<jlong>(ram));
        return ramObj;
    */
    private static native CNROM ROM(long ptr); /*
        CodeNodeNano* nano = reinterpret_cast<CodeNodeNano*>(ptr);
        CNROM<CodeNodeNano::ROM_SIZE>* rom = &nano->ROM();
        jobject romObj = env->NewObject(cnmcuJava::CNROM, cnmcuJava::CNROM_init, reinterpret_cast<jlong>(rom));
        return romObj;
    */
}