package com.github.angel.raa.modules.prototype;

public interface Prototype<T extends Prototype<T>> extends Cloneable {
    T clone();
    T deepClone();
    T reset();


}