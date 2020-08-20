package info.blockchain.api.Json;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BuildJsonFilesThreads {

    BuildJsonFiles BJF = new BuildJsonFiles();

    public  void ThreadBlocJanvier() throws Exception
    {

        int debut = 610682;
        int fin = 615424;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Janvier");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de JANVIER ok");
    }


    public  void ThreadTransactionJanvier() throws Exception
    {

        int debut = 610682;
        int fin = 615424;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Janvier");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de JANVIER ok");
    }


    public  void ThreadBlocFevrier() throws Exception
    {

        int debut = 615424;
        int fin = 619578;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Fevrier");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de fevrier ok");
    }


    public  void ThreadTransactionFevrier() throws Exception
    {

        int debut = 615424;
        int fin = 619578;
        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Février");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Février ok");
    }



    public  void ThreadBlocMars() throws Exception
    {

        int debut = 619578;
        int fin = 623823;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Mars");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Mars ok");
    }


    public  void ThreadTransactionMars() throws Exception
    {

        int debut = 619578;
        int fin = 623823;
        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Mars");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Mars ok");
    }




    public  void ThreadBlocAvril() throws Exception
    {

        int debut = 623823;
        int fin = 628331;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Avril");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Avril ok");
    }


    public  void ThreadTransactionAvril() throws Exception
    {

        int debut = 623823;
        int fin = 628331;
        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Avril");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Avril ok");
    }



    public  void ThreadBlocMai() throws Exception
    {

        int debut = 628331;
        int fin = 632533;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Mai");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Mai ok");
    }


    public  void ThreadTransactionMai() throws Exception
    {

        int debut = 628331;
        int fin = 632533;
        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Mai");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Mai ok");
    }


    public  void ThreadBlocJuin() throws Exception
    {

        int debut = 632533;
        int fin = 637078;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Juin");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Juin ok");
    }


    public  void ThreadTransactionJuin() throws Exception
    {

        int debut = 632533;
        int fin = 637078;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Juin");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Juin ok");
    }



    public  void ThreadBlocJuillet() throws Exception
    {

        int debut = 637078;
        int fin = 641662;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Juillet");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Juillet ok");
    }


    public  void ThreadTransactionJuillet() throws Exception
    {

        int debut = 637078;
        int fin = 641662;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Juillet");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Juillet ok");
    }



    public  void ThreadBlocAout() throws Exception
    {

        int debut = 641662;
        int fin = 644062;

        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des blocs de Aout");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.BlocJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.BlocJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des blocs de Aout ok");
    }


    public  void ThreadTransactionAout() throws Exception
    {
        int debut = 641662;
        int fin = 644062;


        // create a pool of threads, 10 max jobs will execute in parallel
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // submit jobs to be executing by the pool

        System.out.println("Lancement ajout des transactions de Aout");
        for (int i = debut; i < fin; i+=100)
        {
            int finalI = i;

            threadPool.submit(new Runnable()
            {
                public void run()
                {

                    int prev = finalI - 100;
                    try
                    {

                        BJF.TransactionJSON(prev, finalI);
                        if ( fin - finalI < 100)
                        {
                            BJF.TransactionJSON(finalI, fin);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

        }

        // once you've submitted your last job to the service it should be shut down
        threadPool.shutdown();
        // wait for the threads to finish if necessary
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Ajout des transactions de Aout ok");
    }



}
