#include<stdio.h>
#define SIZE 49


main(){

   int i;
   double p[SIZE];
   double p1[SIZE];
   FILE *fpinC0;
   FILE *fpoutC0;
   FILE *finputC0Data;
   FILE *foutputC0Data;
   FILE *foutputC1Data;
   char inputC0[]="c0";
   char outputC0[]="C0.dat";
   char inputC0Data[]="verMos3.out";
   char outputC0Data[]="C1.dat";
   char outputC1Data[]="C2";
   
  

//   fpinC0 = fopen(inputC0,"rb");
//   fread(p, sizeof(double), SIZE, fpinC0);
//   fclose(fpinC0);
//   
//   
//   fpoutC0 = fopen(outputC0,"w");
//   
//   for (i = 0; i <= (SIZE-1); i++) {
//
//      fprintf(fpoutC0, "%e\n", p[i]);
//
//   }
//
//   fclose(fpoutC0);
//
   
   finputC0Data = fopen(inputC0Data,"r");

   for (i = 0; i <= (SIZE-1); i++) {

      fscanf(finputC0Data, "%lf", &p1[i]);

   }

   fclose(finputC0Data);
   foutputC0Data = fopen(outputC0Data,"w");
   
   for (i = 0; i <= (SIZE-1); i++) {

      fprintf(foutputC0Data, "%e\n", p1[i]);

   }
   fclose(foutputC0Data);
  

 
   foutputC1Data = fopen(outputC1Data,"wb");
   fwrite(p1, sizeof(double), SIZE, foutputC1Data);
   fclose(foutputC1Data);
   
   return 0;

}
