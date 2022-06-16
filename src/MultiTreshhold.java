/**
 * MultiTreshold-Filter
 * 
 * Treshold Filter mit mehreren Grautönen
 */
public class MultiTreshhold extends PixelFilter{

    /***
     * Setzt die in den Einzelnen Grautoene anhand ihrer Schwellwertes
     */
    public int calculate(int pixelColor) {

        int rot =(pixelColor >>16) & 0xff;
        int gruen =(pixelColor >>8) & 0xff;
        int blau =pixelColor & 0xff ;
    
        int aktHelligkeit = (rot + gruen + blau) / 3; // Durchschnitt der Helligkeit
         
        // angegebene Schwellwerte 64, 128, 192
        int schwellwert[] = new int[3];

//        final int SCHWELLWERT, SCHWELLWERT2, SCHWELLWERT3;
//        schwellwert[0]  =64;
//        schwellwert[1] =128;
//        schwellwert[2] =192;

        //erforderliche Werte der Grautöne

        final int  GRAUTON1=0;
        final int  GRAUTON2=92;
        final int  GRAUTON3=160;
        final int  GRAUTON4=255;

            //Einsetzen der Grautöne

            if(aktHelligkeit >= schwellwert[2]){
                aktHelligkeit = GRAUTON4;
            }else if( aktHelligkeit >= schwellwert[1]){
                aktHelligkeit = GRAUTON3;
            }else if( aktHelligkeit >= schwellwert[0]){
                aktHelligkeit = GRAUTON2;
            }
            else{
                aktHelligkeit=GRAUTON1 ;
            }

            pixelColor = 0;
            
            pixelColor |=  (aktHelligkeit << 16);
            pixelColor |= (aktHelligkeit << 8);
            pixelColor |= aktHelligkeit;
            return pixelColor;
    
    
        }
}    