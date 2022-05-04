package org.example.overridingoverloading;

class Red extends Blue{

    // overriding
    @Override
    void paint() {
        System.out.println("Painting red");
    }

    // overriding & overloading
    @Override
    void paint(int times) {
        while (times-- > 0) {
            System.out.println("Painting red");
        }
    }
}
