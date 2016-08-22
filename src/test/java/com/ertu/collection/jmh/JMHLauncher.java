package com.ertu.collection.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author egry35
 */
public class JMHLauncher {

    private static final int NB_ITERATIONS = 5;

    /**
     * Methode de lancement du benchmark.
     * @param clazz Class de la classe contenant les tests de perf à lancer (@Benchmark)
     * @param isEnableAssertions True si on active les assertions (ATTENTION ralentit les perf)
     * @throws RunnerException
     */
    public void launchJMHBenchmark(final Class<?> clazz) throws RunnerException {
        ChainedOptionsBuilder cob = new OptionsBuilder()
                .include(clazz.getSimpleName())
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .warmupIterations(NB_ITERATIONS)
                .measurementIterations(NB_ITERATIONS)
                .jvmArgs("-server");

        Options options = cob.build();
        try {
            new Runner(options).run();
        } catch (RuntimeException ex) {
            if (ex.getMessage().contains("Unable to find the resource: /META-INF/BenchmarkList")) {
                throw new RuntimeException("Lancer un \"mvn install -DskipTests\" avant de lancer le test (car JMH a besoin de classes préalablement générées par le système d'annotaion JMH => " + ex.getMessage() + ") /// si ERREUR PERSISTE, alors 1.vider le répertoire \"target\", 2.relancer un \"mvn install -DskipTests\"", ex);
            } else {
                throw ex;
            }
        }
    }

}
