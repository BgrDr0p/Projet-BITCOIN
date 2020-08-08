package info.blockchain.api;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DLJSON implements Runnable {

    private int debut;
    private int fin;

    public DLJSON(int debut, int fin)
    {
        this.debut = debut;
        this.fin = fin;
    }



    @Override
    public void run()
    {
        for(int dl = debut; dl < fin; dl ++)
            try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://blockchain.info/rawblock/" + dl + "").openStream());
                 FileOutputStream fileOS = new FileOutputStream("D:\\Bureau\\data\\" + dl +".json")) {
                byte data[] = new byte[1024];
                int byteContent;
                while ((byteContent = inputStream.read(data, 0, 1024)) != -1)
                {
                    fileOS.write(data, 0, byteContent);

                }
                System.out.println("fichier " + dl + " OK !!!");
            } catch (IOException e)
            {
                e.printStackTrace();
                // handles IO exceptions
            }
    }

    public static void main(String[] args)
    {
        // Donc de 556 453 à 560 824 pour le mois de Janvier


        Thread t1 = new Thread(new DLJSON(559101, 559150), "Thread - T1");
        Thread t2 = new Thread(new DLJSON(559150, 559200 ), "Thread - T2");
        Thread t3 = new Thread(new DLJSON(559200, 559250), "Thread - T3");
        Thread t4 = new Thread(new DLJSON(559250, 559300), "Thread - T4");
        Thread t5 = new Thread(new DLJSON( 559300, 559350), "Thread - T5");
        Thread t6 = new Thread(new DLJSON(559350, 559400), "Thread - T6");
        Thread t7 = new Thread(new DLJSON(559400, 559450), "Thread - T7");
        Thread t8 = new Thread(new DLJSON(559450, 559500), "Thread - T8");
        Thread t9 = new Thread(new DLJSON(559500, 559550), "Thread - T9");
        Thread t10 = new Thread(new DLJSON(559550,559560), "Thread - T10");
        Thread t11 = new Thread(new DLJSON(559560, 559570), "Thread - T11");
        Thread t12 = new Thread(new DLJSON(559570, 559580), "Thread - T12");
        Thread t13 = new Thread(new DLJSON(559580, 559590), "Thread - T13");
        Thread t14 = new Thread(new DLJSON(559590, 559600), "Thread - T14");
        Thread t15 = new Thread(new DLJSON(559600,559700), "Thread - T15");
        Thread t16 = new Thread(new DLJSON(559700, 559800), "Thread - T16");
        Thread t17 = new Thread(new DLJSON(559900,560000), "Thread - T17");
        Thread t18 = new Thread(new DLJSON(560000, 560100), "Thread - T18");
        Thread t19 = new Thread(new DLJSON(560100, 560200), "Thread - T19");
        Thread t20 = new Thread(new DLJSON(560200, 560300), "Thread - T20");
        Thread t21 = new Thread(new DLJSON( 560300, 560400), "Thread - T21");
        Thread t22 = new Thread(new DLJSON(560400, 560500), "Thread - T22");
        Thread t23 = new Thread(new DLJSON(560500, 560600), "Thread - T23");
        Thread t24 = new Thread(new DLJSON(560600, 560700), "Thread - T24");
        Thread t25 = new Thread(new DLJSON(560700, 560800), "Thread - T25");
        Thread t26 = new Thread(new DLJSON(560800, 560825), "Thread - T26");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t20.start();
        t21.start();
        t22.start();
        t23.start();
        t24.start();
        t25.start();
        t26.start();



    }


    }
