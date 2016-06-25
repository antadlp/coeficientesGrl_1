package coeficientesGrl_1;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author antonio2
 */
public class CAplication {
    public static void main(String[] args)  {
        //String archivoAcopiar = "dynamovieParcial.xyz";
        //String archivoAcopiar = "dynamovie.xyz";
        //String archivocreado = "dynamovieParcialPrueba.xyz";
        //String archivoAcopiar = "parametros";
        //String archivocreado = "parametroscodigo";
        //int renglones = 190;
        //int LineaLinea;
        //String LineaCopiada;
        //String path = new java.io.File(".").getCanonicalPath();
        //String ruta = System.getProperty("user.dir");
        //CopiarArchivo ManejoArchivo = new CopiarArchivo();
        //WriteArch PruebaFuncion = new WriteArch();
        //CreacionInputs PruebaInputs = new CreacionInputs();
        //CopiarArchivo archivo = new CopiarArchivo();
        //ManejoArchivo.Copiar(archivoAcopiar, archivocreado, renglones);
        //BuscarYdarNumLineaDeLineaAaB(String filename, String info1, int LineaA, int LineaB) 
        //LineaLinea = PruebaFuncion.BuscarYdarNumLineaDeLineaAaB(archivoAcopiar, "molec", -2, 190);
        //LineaLinea = PruebaFuncion.BuscarYdarLineaUltimaPalabraDeLineaAaB(archivoAcopiar, "molec", 1, 12);
        //LineaCopiada = ManejoArchivo.CopiarLineaIndicada(archivoAcopiar, 11);
        
        //System.out.println(algo);
        //System.out.println(LineaCopiada);
        ///home/antoniod2/NetBeansProjects/CrearInputsGaussian/tresframes.vmd
        //PruebaInputs.CrearImputsGaussian(archivoAcopiar, "PruebaFrame", ruta);

        //ManejoArchivo.CrearCodigoDe("tresframes.vmd", "CodigoSecuenciaVMD.vmd", 521);
        //PruebaInputs.CrearlosDeCodigo("PruebaExt.vmd", "/planb/carpeta1/", 200, 400);
        //archivo.CrearCodigoDe(archivoAcopiar, archivocreado, 4);
        
        String archivoGaussian = "g092.log";
        int i, j, k, l, m, n;
        int numLineaMolOr;
        int renglonesTotales;
        String Linea01MolOr;
        String[] words;
        int numMos = 13;
//        float[] arreglo1 = new float[130*130];
        String[] arreglo1 = new String[numMos*numMos];
        String[] arreglo2 = new String[numMos*numMos];
        String[] arreglo3 = new String[numMos*numMos];


        
        String ArchivoSalida = "verMos.out";
        String ArchivoSalida2 = "verMos2.out";
        String ArchivoSalida3 = "verMos3.out";


        int palabras;
        int lineaFinalMos;
        
        
        WriteArch operacionesFile = new WriteArch();
        CopiarArchivo operacionesFile02 = new CopiarArchivo();
        
        
        renglonesTotales = operacionesFile.countLines(archivoGaussian);
        
        
        
        System.out.println("\nrenglones totales: ");
        System.out.println(renglonesTotales);
     //   numLineaMolOr = operacionesFile.salidalineabuscada;
        numLineaMolOr = operacionesFile.BuscarYdarNumLineaDeLineaAaB(archivoGaussian, "Molecular Orbital Coefficients", 1, renglonesTotales);
        System.out.println("\nNum Linea Molecular Orbitals: ");
        System.out.println(numLineaMolOr);
        
        Linea01MolOr = operacionesFile02.CopiarLineaIndicada(archivoGaussian, numLineaMolOr + 5);
        
        System.out.println("\nString linea MolOr");
        System.out.println(Linea01MolOr);
        
        words = Linea01MolOr.split("\\s+");
        
        
        System.out.println("\nPalabra cinco Linea MolOr");
        System.out.println(words[5]);
        
        System.out.println("\n\n");

        palabras = words.length;
        
        System.out.println("\n\n");
        
        System.out.println("numero palabras   " + palabras);
        lineaFinalMos = operacionesFile.BuscarYdarNumLineaDeLineaAaB(archivoGaussian, "Density Matrix:", 1, renglonesTotales);
        System.out.println("\n\n");
        System.out.println("linea final Mos   " + lineaFinalMos);
        
        //ManejoArchivos.CrearArchivo(ArchivoSalida);
        //ManejoArchivos.EscribeDeNuevo(ArchivoSalida, columna.trim());
        operacionesFile.CrearArchivo(ArchivoSalida);
        operacionesFile.CrearArchivo(ArchivoSalida2);
        operacionesFile.CrearArchivo(ArchivoSalida3);
        

        
        
        k = 1;
        l = 0;
        m = 0;
        for(i = 1; i<=((lineaFinalMos - (numLineaMolOr + 4))); i++){

            Linea01MolOr = operacionesFile02.CopiarLineaIndicada(archivoGaussian, numLineaMolOr + (4 - 1) + i);
            words = Linea01MolOr.split("\\s+");
            palabras = words.length;
    //        System.out.println("verWords " + words[5] + "XX" +i);
            
            if(((numMos % 5)!= 0)^(i == ((numMos*numMos)- (numMos % 5) - 1))){
                for(j = (palabras - 1); j >= (((palabras - 1) - (5 - (numMos % 5))) + 1); j--){
                    arreglo1[l] = words[j];
                    operacionesFile.EscribeDeNuevo(ArchivoSalida, arreglo1[l]);
                    operacionesFile.EscribeDeNuevo(ArchivoSalida, "\n");
                     System.out.println(arreglo1[l]);
                     l = l + 1;
                }
                if (i == (numMos*k + m)){
                    i = i + 3;
                    m = m + 3;
                    k++;
                } 
            } else {
                for(j = (palabras - 1); j >= (((palabras - 1) - 5) + 1); j--){
                     arreglo1[l] = words[j];
                     operacionesFile.EscribeDeNuevo(ArchivoSalida, arreglo1[l]);
                     operacionesFile.EscribeDeNuevo(ArchivoSalida, "\n");
                     System.out.println(arreglo1[l]);
                     l = l + 1;
                }
                if (i == (numMos*k + m)){

                    i = i + 3;
                    m = m + 3;
                    k++;

                } 






                }//for check
                 
             
        }//for check
        

        
        k = 0;
        for (l=0;l<=(numMos*numMos-1); l=l+5){
            if(k == ((numMos*numMos)- (numMos % 5) - 1)){
                for(j=((int) (numMos % 5)); j>=1; j--){
                arreglo2[k]=arreglo1[(l + j)-1];
                operacionesFile.EscribeDeNuevo(ArchivoSalida2, arreglo2[k]);
                operacionesFile.EscribeDeNuevo(ArchivoSalida2, "\n");
                k++;
                } 
            } else {
                for(j=5; j>=1; j--){
                arreglo2[k]=arreglo1[(l + j)-1];
                operacionesFile.EscribeDeNuevo(ArchivoSalida2, arreglo2[k]);
                operacionesFile.EscribeDeNuevo(ArchivoSalida2, "\n");
                k++;
                }
            }
        } //for chceck   

             
    
        
        l=0;
        for(i=0; i<=(numMos*5-5); i+=5){
            for(j=0;j<=(((int) Math.floor(numMos/5.0))-1);j++){
                
                if(l == ((int) ((numMos*numMos)- (numMos % 5) - 1))){
                    System.out.println(i);
                    arreglo3[l]=arreglo2[(j*(130*5))+(i)+k-1];
                    operacionesFile.EscribeDeNuevo(ArchivoSalida3, arreglo3[l]);
                    operacionesFile.EscribeDeNuevo(ArchivoSalida3, "\n");
                    l++;
                }else {
                
                    for(k=1;k<=5;k++){
                        System.out.println(i);
                        arreglo3[l]=arreglo2[(j*(numMos*5))+(i)+k-1];
                        operacionesFile.EscribeDeNuevo(ArchivoSalida3, arreglo3[l]);
                        operacionesFile.EscribeDeNuevo(ArchivoSalida3, "\n");
                        l++;
                    }
                }
                
            }
        }
        
        

        
        
        
        
//        for (j=1;j<=(130*130-1); j++){
//            
//            i= (int) Math.ceil((double) j/5.0);
//            
//            System.out.println(i);
//            arreglo2[j-1]=arreglo1[i*5 - (j % 5)];
//            
//            operacionesFile.EscribeDeNuevo(ArchivoSalida2, arreglo2[j-1]);
//            operacionesFile.EscribeDeNuevo(ArchivoSalida2, "\n");
//            
//            
//        }
//        arreglo2[130*130-1] = arreglo1[130*130-5];
//        operacionesFile.EscribeDeNuevo(ArchivoSalida2, arreglo2[j-1]);
//        
        
        
        
        System.out.println("\n");
        System.out.print(arreglo2[(130*130 -1)]);
                System.out.println("\n");
        System.out.print(arreglo2[(130*130 -2)]);
                System.out.println("\n");
        System.out.print(arreglo2[(130*130 -3)]);
                System.out.println("\n");
        System.out.print(arreglo2[(130*130 -4)]);
                    
        
    }
     
    
}
//http://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java