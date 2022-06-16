
public class MultiTreshhold extends PixelFilter{

    public int calculate(int pixelColor) {

        int rot =(pixelColor >>16) & 0xff;
        int gruen =(pixelColor >>8) & 0xff;
        int blau =pixelColor & 0xff ;
    
        int aktHelligkeit = (rot + gruen + blau) / 3; //für die reduzierung der Helligkeit
         
        final int SCHWELLWERT, SCHWELLWERT2, SCHWELLWERT3;
        SCHWELLWERT  =64;
        SCHWELLWERT2 =128;
        SCHWELLWERT3 =192;

        final int  GRAUTON1=0;
        final int  GRAUTON2=92;
        final int  GRAUTON3=160;
        final int  GRAUTON4=255;


            if(aktHelligkeit >= SCHWELLWERT3){
                aktHelligkeit = GRAUTON4;
            }else if( aktHelligkeit >= SCHWELLWERT2){
                aktHelligkeit = GRAUTON3;
            }else if( aktHelligkeit >= SCHWELLWERT){
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