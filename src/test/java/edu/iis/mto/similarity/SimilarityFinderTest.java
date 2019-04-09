package edu.iis.mto.similarity;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {

    @Test
    public void calculateJackardSimilarityTestWhereSequenceLengthIsZero() {
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int[] seq = {};
        int[] seq2 = {};
        double result = 1.0d;

        Assert.assertThat(result, is(equalTo(similarityFinder.calculateJackardSimilarity(seq, seq2))));
    }
}