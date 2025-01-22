package com.demo.sealedinterface;

public sealed interface Employee permits Doctor, Nurse {
    void performDuties();
}
