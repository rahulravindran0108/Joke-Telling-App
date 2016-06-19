package com.rahulravindran.udacity;

import java.util.Random;

public class JokesLibrary {

    private static final String[] JOKES = {
            "A computer once beat me at chess, but it was no match for me at kick boxing.",
            "What did one ocean say to the other ocean? Nothing, they just waved.",
            "If you owe the bank $100,000, the bank owns you. If you owe the bank $1,000,000,000, you own the bank.",
            "When everything's coming your way, you're in the wrong lane.",
            "Whenever I find the key to success, someone changes the lock.",
            "Why did the bee get married? Because he found his honey.",
            "I just let my mind wander, and it didn't come back.",
            "IRS: We've got what it takes to take what you've got.",
            "I asked God for a bike, but I know God works in mysterious ways. So I stole a bike and asked for forgiveness.",
            "If I agreed with you we'd both be wrong.",
            "If God is watching us, the least we can do is be entertaining.",
            "I like work: it fascinates me. I can sit and look at it for hours.",
    };
    private static final Random rndmGenerator = new Random();

    public static String getRandomJoke() {
        return JOKES[rndmGenerator.nextInt(JOKES.length)];
    }

}
