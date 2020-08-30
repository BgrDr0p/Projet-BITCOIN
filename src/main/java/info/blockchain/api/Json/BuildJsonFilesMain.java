package info.blockchain.api.Json;

public class BuildJsonFilesMain
{





    public static void main(String args[]) throws Exception
    {
        BuildJsonFilesThreads T = new BuildJsonFilesThreads();


        ////////////// JANVIER /////////////////////////
        new Thread(() ->
        {
            try
            {

                T.ThreadBlocJanvier();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(10000);
                T.ThreadTransactionJanvier();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();
        ////////////// JANVIER /////////////////////////


        ////////////// FEVRIER /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(20000);
                T.ThreadBlocFevrier();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(30000);
                T.ThreadTransactionFevrier();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// FEVRIER /////////////////////////


        ////////////// MARS /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(40000);
                T.ThreadBlocMars();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(50000);
                T.ThreadTransactionMars();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// MARS /////////////////////////


        ////////////// AVRIL /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(50000);
                T.ThreadBlocAvril();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(60000);
                T.ThreadTransactionAvril();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// AVRIL /////////////////////////


        ////////////// MAI /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(70000);
                T.ThreadBlocMai();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(80000);
                T.ThreadTransactionMai();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// MAI /////////////////////////


        ////////////// JUIN /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(90000);
                T.ThreadBlocJuin();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(100000);
                T.ThreadTransactionJuin();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// JUIN /////////////////////////


        ////////////// JUILLET /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(100000);
                T.ThreadBlocJuillet();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(110000);
                T.ThreadTransactionJuillet();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// JUILLET /////////////////////////

        ////////////// AOUT /////////////////////////
        new Thread(() ->
        {
            try
            {
                Thread.sleep(120000);
                T.ThreadBlocAout();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->
        {
            try
            {
                Thread.sleep(130000);
                T.ThreadTransactionAout();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        ////////////// AOUT /////////////////////////




    }







    }














