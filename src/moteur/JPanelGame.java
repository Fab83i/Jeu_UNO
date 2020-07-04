package moteur;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JPanelGame extends JPanel {

    private BufferedImage image;

    private BufferedImage green_0;
    private BufferedImage green_1;
    private BufferedImage green_2;
    private BufferedImage green_3;
    private BufferedImage green_4;
    private BufferedImage green_5;
    private BufferedImage green_6;
    private BufferedImage green_7;
    private BufferedImage green_8;
    private BufferedImage green_9;
    private BufferedImage green_passer;
    private BufferedImage green_sens;
    private BufferedImage green_plusDeux;

    private BufferedImage red_0;
    private BufferedImage red_1;
    private BufferedImage red_2;
    private BufferedImage red_3;
    private BufferedImage red_4;
    private BufferedImage red_5;
    private BufferedImage red_6;
    private BufferedImage red_7;
    private BufferedImage red_8;
    private BufferedImage red_9;
    private BufferedImage red_passer;
    private BufferedImage red_sens;
    private BufferedImage red_plusDeux;

    private BufferedImage yellow_0;
    private BufferedImage yellow_1;
    private BufferedImage yellow_2;
    private BufferedImage yellow_3;
    private BufferedImage yellow_4;
    private BufferedImage yellow_5;
    private BufferedImage yellow_6;
    private BufferedImage yellow_7;
    private BufferedImage yellow_8;
    private BufferedImage yellow_9;
    private BufferedImage yellow_passer;
    private BufferedImage yellow_sens;
    private BufferedImage yellow_plusDeux;

    private BufferedImage blue_0;
    private BufferedImage blue_1;
    private BufferedImage blue_2;
    private BufferedImage blue_3;
    private BufferedImage blue_4;
    private BufferedImage blue_5;
    private BufferedImage blue_6;
    private BufferedImage blue_7;
    private BufferedImage blue_8;
    private BufferedImage blue_9;
    private BufferedImage blue_passer;
    private BufferedImage blue_sens;
    private BufferedImage blue_plusDeux;

    private BufferedImage joker;
    private BufferedImage superJoker;

    private Talon talon;
    private Pile pile;


    public JPanelGame(Partie partie) {
        this.talon = partie.getTalon();
        this.pile = partie.getPile();

        try{
            this.blue_0 = ImageIO.read(new File(("images/cartesImages/blue_0")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_0 = null;
        }

        try{
            this.blue_1 = ImageIO.read(new File(("images/cartesImages/blue_1")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_1 = null;
        }

        try{
            this.blue_2 = ImageIO.read(new File(("images/cartesImages/blue_2")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_2 = null;
        }

        try{
            this.blue_3 = ImageIO.read(new File(("images/cartesImages/blue_3")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_3 = null;
        }

        try{
            this.blue_4 = ImageIO.read(new File(("images/cartesImages/blue_4")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_4 = null;
        }

        try{
            this.blue_5 = ImageIO.read(new File(("images/cartesImages/blue_5")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_5 = null;
        }

        try{
            this.blue_6 = ImageIO.read(new File(("images/cartesImages/blue_6")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_6 = null;
        }

        try{
            this.blue_7 = ImageIO.read(new File(("images/cartesImages/blue_7")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_7 = null;
        }

        try{
            this.blue_8 = ImageIO.read(new File(("images/cartesImages/blue_8")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_8 = null;
        }

        try{
            this.blue_9 = ImageIO.read(new File(("images/cartesImages/blue_9")));
        } catch (IOException var1){
            System.out.println(var1);
            this.blue_9 = null;
        }

        try{
            this.green_0 = ImageIO.read(new File(("images/cartesImages/green_0")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_0 = null;
        }

        try{
            this.green_1 = ImageIO.read(new File(("images/cartesImages/green_1")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_1 = null;
        }

        try{
            this.green_2 = ImageIO.read(new File(("images/cartesImages/green_2")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_2 = null;
        }

        try{
            this.green_3 = ImageIO.read(new File(("images/cartesImages/green_3")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_3 = null;
        }

        try{
            this.green_4 = ImageIO.read(new File(("images/cartesImages/green_4")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_4 = null;
        }

        try{
            this.green_5 = ImageIO.read(new File(("images/cartesImages/green_5")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_5 = null;
        }

        try{
            this.green_6 = ImageIO.read(new File(("images/cartesImages/green_6")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_6 = null;
        }

        try{
            this.green_7 = ImageIO.read(new File(("images/cartesImages/green_7")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_7 = null;
        }

        try{
            this.green_8 = ImageIO.read(new File(("images/cartesImages/green_8")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_8 = null;
        }

        try{
            this.green_9 = ImageIO.read(new File(("images/cartesImages/green_9")));
        } catch (IOException var1){
            System.out.println(var1);
            this.green_9 = null;
        }



    }




}
