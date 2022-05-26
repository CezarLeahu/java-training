package org.example.functional.fortunes;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class TestFortunes {

    @Test
    public void testCookies() {

        Fortune fortune = new ChineseFortune();

        printFortune(fortune);

        printFortune(new Fortune() {
            @Override
            public String cookie() {
                return "To err is human, but to really foul things up you need a computer.";
            }
        });

        printFortune(() -> "Humans make mistakes. And computers make mistakes really, really fast.");

        //

        printCookie(fortune::cookie);

        printCookie(ChineseFortune::staticCookie);
    }

    void printFortune(Fortune fortune) {
        System.out.println(fortune.cookie());
    }

    void printCookie(Supplier<String> cookieSupplier) {
        System.out.println(cookieSupplier.get());
    }

    @Test
    public void testClojure(){
        int outsideData = 1;

        printFortune(new Fortune() {
            @Override
            public String cookie() {
                return "Cookie" + outsideData;
            }
        });

        printFortune(new Fortune() {
            @Override
            public String cookie() {
                return "Cookie" + 1;
            }
        });

        printFortune(() -> "Cookie" + 1);

        printCookie(this::count);
        printCookie(this::count);
    }

    private static final AtomicInteger COUNT = new AtomicInteger(0);
    private String count() {
        return "Count: " + COUNT.incrementAndGet();
    }

    @Test
    public void testMessageRepeater(){

        MessageRepeater mr1 = new MessageRepeater() {
            @Override
            public String repeat(String msg, int times) {
                return msg.repeat(times);
            }
        };
        printMessage(() -> mr1.repeat("Hello! ", 3));


        MessageRepeater mr2 = (msg, times) -> msg.repeat(times);
        printMessage(() -> mr2.repeat("Bye! ", 2));


        MessageRepeater mr3 = String::repeat;
        printMessage(() -> mr3.repeat("The end! ", 1));

    }

    static void printMessage(Supplier<String> messageSupplier) {
        System.out.println(messageSupplier.get());
    }
}
