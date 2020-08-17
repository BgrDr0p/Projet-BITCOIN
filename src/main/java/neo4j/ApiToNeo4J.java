package neo4j;


import info.blockchain.api.APIException;
import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.regex.Matcher;

public class ApiToNeo4J implements Runnable
{



    private static GraphManager greeter = new GraphManager("bolt://localhost:7687", "neo4j", "root");



    public static void main(String[] args) throws Exception
    {
        // 1er janvier 2020  de 610 680 à 611 003
        StopWatch stopwatch = new StopWatch();
        new Thread(() -> {
            try
            {

                stopwatch.start();
                greeter.insertOutputs(610680,610681);
                stopwatch.stop();
                long timeTaken = stopwatch.getTime();
                System.out.println("ca a pris " + timeTaken);
            } catch (APIException | IOException e)
            {
                e.printStackTrace();
            }
        }).start();

            /*

       new Thread(() -> {
            try
            {
                Thread.sleep(100);
                greeter.insertTransaction(610690,610700);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();




        new Thread(() -> {
            try
            {
                Thread.sleep(200);
                greeter.insertTransaction(610700,610710);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try
            {
                Thread.sleep(30);
                greeter.insertTransaction(610710,610720);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(300);
                greeter.insertTransaction(610720,610730);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(400);
                greeter.insertTransaction(610730,610740);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();



        new Thread(() -> {
            try
            {
                Thread.sleep(500);
                greeter.insertTransaction(610740,610750);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(70);
                greeter.insertTransaction(610760,610770);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(700);
                greeter.insertTransaction(610780,610790);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(500);
                greeter.insertTransaction(610790,610800);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(900);
                greeter.insertTransaction(610800,610900);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try
            {
                Thread.sleep(900);
                greeter.insertTransaction(610900,611000);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try
            {
                Thread.sleep(800);
                greeter.insertTransaction(611000, 611003);
            } catch (APIException | IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();









    */

    }


    @Override
    public void run() {

    }
}


