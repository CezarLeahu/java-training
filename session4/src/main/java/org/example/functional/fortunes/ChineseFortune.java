package org.example.functional.fortunes;

import java.util.Random;

import static java.lang.Math.abs;

public class ChineseFortune implements Fortune {
    final static String[] FORTUNES = {
        "The second mouse is going to get the cheese although it is the early bird who is going to get the worm.",
        "There is no reason to worry! Your friend at this moment happens to be patience.",
        "Make it a point not to go after happiness – try to build it.",
        "Before becoming easy every single thing is extremely difficult.",
        "Although a ship is safe in the harbor, this is not the reason why they have been constructed.",
        "Anyone hardly understands how much can be gained simply by ignoring the upcoming days.",
        "A cup proves to be useful provided it remains empty.",
        "If you do not like to be criticized then it will be a sensible idea to say nothing, do nothing, and also be nothing.",
        "Big journeys start with only one step.",
        "Never be scared of developing gradually, but be scared only of standing motionless.",
        "It is imperative for us to have young ambitions and old memories.",
        "Any individual who does not expect any gratitude will never suffer from disappointment.",
        "I forget after hearing. I remember after seeing. I understand after doing.",
        "Although we are not aware of the future, here is a cookie.",
    };
    private final static Random RANDOM = new Random();

    @Override
    public String cookie() {
        return FORTUNES[abs(RANDOM.nextInt()) % FORTUNES.length];
    }

    public static String staticCookie() {
        return FORTUNES[abs(RANDOM.nextInt()) % FORTUNES.length];
    }
}
