package org.example.overridingoverloading;

class Blue {

    void paint() {
        System.out.println("Painting blue");
    }

    // overloading
    void paint(int times) {
        while (times-- > 0) {
            System.out.println("Painting blue");
        }
    }
}
