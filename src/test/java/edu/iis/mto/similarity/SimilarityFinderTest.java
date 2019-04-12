package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimilarityFinderTest {

    SimilarityFinder similarityFinder;

    @Test
    public void calculateJackardSimilarityTestWhereSequenceLengthIsZero() {
        similarityFinder = new SimilarityFinder();
        int[] seq = {};
        int[] seq2 = {};
        double result = 1.0d;

        Assert.assertThat("should be 1.0d", result, is(equalTo(similarityFinder.calculateJackardSimilarity(seq, seq2))));
    }

    @Test
    public void calculateJacardSimilarityTestWhereSequenceAreTheSameWithTheSameElements() {
        int[] seq = {1, 2, 3, 4, 5};
        int[] seq2 = {5, 4, 3, 2, 1};
        double result = 1.0d;

        similarityFinder = new SimilarityFinder((key, seq1) -> {
            if (key == seq1[0] || key == seq1[1] || key == seq1[2] || key == seq1[3] || key == seq1[4])
                return SearchResult.builder().withFound(true).build();
            else return SearchResult.builder().withFound(false).build();
        });

        Assert.assertThat("should be 1.0", similarityFinder.calculateJackardSimilarity(seq, seq2), is(equalTo(result)));
    }

    @Test
    public void calculateJacardSimilarityTestWhereSequenceAreDifferent() {
        int[] seq = {1, 2, 3, 4, 5};
        int[] seq2 = {6, 7, 8, 9, 10};
        double result = 0.0;

        similarityFinder = new SimilarityFinder((key, seq1) -> {
            if (key == seq1[0] || key == seq1[1] || key == seq1[2] || key == seq1[3] || key == seq1[4])
                return SearchResult.builder().withFound(true).build();
            else return SearchResult.builder().withFound(false).build();
        });

        Assert.assertThat("should be 0.0", similarityFinder.calculateJackardSimilarity(seq, seq2), is(equalTo(result)));
    }


    @Test
    public void calculateJacardSimilarityTestWhereSequenceAreSimilar() {
        int[] seq = {1, 2, 3, 4, 5, 6};
        int[] seq2 = {1, 2, 3};
        double result = 0.5d;

        similarityFinder = new SimilarityFinder((key, seq1) -> {
            if (key == seq1[0] || key == seq1[1] || key == seq1[2])
                return SearchResult.builder().withFound(true).build();
            else return SearchResult.builder().withFound(false).build();
        });

        Assert.assertThat("should be 0.5d", similarityFinder.calculateJackardSimilarity(seq, seq2), is(equalTo(result)));
    }


}