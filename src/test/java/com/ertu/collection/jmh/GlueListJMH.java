package com.ertu.collection.jmh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import com.ertu.collection.GlueList;

/**
 * Lanceur sous forme de Main afin de ne pas lancer les tests JMH (perf) dans le TUs
 * (meme si cela serait facilement possible en tranformant le main en méthode + annotation @Test).
 * @author egry35
 */
@State(Scope.Thread)
public class GlueListJMH {

    int dataCount500k = 500_000;

    int dataCount1m = 1_000_000;

    int dataCount10m = 10_000_000;

    @Benchmark
    public void test_1_add_500k_linked_list() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < dataCount500k; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    public void test_2_add_500k_array_list() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < dataCount500k; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void test_3_add_500k_glue_list() {
        List<Integer> glueList = new GlueList<>();
        for (int i = 0; i < dataCount500k; i++) {
            glueList.add(i);
        }
    }

    @Benchmark
    public void test_4_add_1m_linked_list() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < dataCount1m; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    public void test_5_add_1m_array_list() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < dataCount1m; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void test_6_add_1m_glue_list() {
        List<Integer> glueList = new GlueList<>();
        for (int i = 0; i < dataCount1m; i++) {
            glueList.add(i);
        }
    }

    @Benchmark
    public void test_7_add_10m_linked_list() {
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < dataCount10m; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    public void test_8_add_10m_array_list() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < dataCount10m; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void test_9_add_10m_glue_list() {
        List<Integer> glueList = new GlueList<>();
        for (int i = 0; i < dataCount10m; i++) {
            glueList.add(i);
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        new JMHLauncher().launchJMHBenchmark(GlueListJMH.class);
    }
}
