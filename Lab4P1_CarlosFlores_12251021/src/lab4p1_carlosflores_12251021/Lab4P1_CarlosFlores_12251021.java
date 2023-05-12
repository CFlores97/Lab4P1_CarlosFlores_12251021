
package lab4p1_carlosflores_12251021;
import java.util.Scanner;
public class Lab4P1_CarlosFlores_12251021 {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        
        while(running){
            System.out.println("1. Conjuntos");
            System.out.println("2. Contraseña mejorada");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el primer conjunto A: ");
                    String A = sc.next();
                    System.out.println("Ingrese el segundo conjunto B: ");
                    String B = sc.next();
                    
                    String C = "C={";
                    String union = "";
                    String interseccion = "";
                    
                    boolean iguales = true; 
                    boolean prim_aceptable = false;
                    boolean seg_aceptable = false;
                    boolean ter_aceptable = false;
                    boolean cuar_aceptable = false;
                    boolean aceptable = false;
                    
                    
                    if ((A.charAt(0) >= 65 && A.charAt(0) <= 90 && A.charAt(1) == '=' && A.charAt(2) == '{' ) 
                        && ((B.charAt(0) >= 65 && B.charAt(0) <= 90) && B.charAt(1) == '=' && B.charAt(2) == '{'))
                    {
                        prim_aceptable = true;

                    }
                    
                    
                    for (int i = 3; i <= A.length()-1; i++)
                    {
                        if (A.charAt(i) >= 97 && A.charAt(A.length() - 2) <= 122)
                        {
                            seg_aceptable = true;
                        }
                    }
                    
                    for (int i = 3; i <= B.length()-1; i++)
                    {
                        if (B.charAt(i) >= 97 && B.charAt(B.length() - 2) <= 122)
                        {
                            ter_aceptable = true;
                        }
                    }
                    
                    if (A.charAt(A.length() - 1) == '}' && B.charAt(B.length() - 1) == '}')
                    {
                        cuar_aceptable = true;
                    }
                    
                    
                    if (prim_aceptable && seg_aceptable && ter_aceptable  && cuar_aceptable)
                    {
                        aceptable = true;
                        System.out.println("All cond. have passed. ");
                    }
                    else{
                        System.out.println("incorrect pattern");
                    }
                    
                    String temp_1 = A.substring(3, A.length());
                    String temp_2 = B.substring(3, B.length());
                    String new_temp1 = temp_1.replace("}", "");
                    String new_temp2 = temp_2.replace("}", "");
                    
                    if (new_temp1.equals(new_temp2))
                    {
                        System.out.println("Ambos conjuntos son iguales");
                    }
                    else
                    {
                        System.out.println("Ambos conjuntos no son iguales");
                        
                        
                        union = "Union: " + C + new_temp1 + "," + new_temp2;
                        System.out.println(union + "}");
                        
                        for (int i = 0; i <= new_temp1.length() - 1; i++){
                            for (int j = 0; j <= new_temp2.length() - 1; j++){
                                if(new_temp1.charAt(i) == new_temp2.charAt(j)){
                                    interseccion += new_temp1.charAt(i);
                                }
                            }
                        }
                        
                        String new_interseccion = interseccion.replace(",", "");
                        
                        
                        System.out.println("Interseccion: C={" + new_interseccion +"," + "}");
                        

                    }

                    
                    break;
                case 2:
                    System.out.println("Ingrese la contraseña: ");
                    String pass = sc.next();
                    String new_pass = "";
                    boolean letters = false;
                    boolean numbers = false;
                    boolean num_char = false;
                    
                    if (pass.length() >= 8){
                        num_char = true;
                        
                        
                        for (int i = 0; i<= pass.length() - 1; i++)
                        {
                            if(pass.charAt(i) >= 65 && pass.charAt(i) <= 90 
                                    || pass.charAt(i) >= 97 && pass.charAt(i) <= 122 )
                            {
                                letters = true;
                            }

                            if(pass.charAt(i) >= 49 && pass.charAt(i) <= 57)
                            {
                                numbers = true;
                            }


                        }
                    }
                    else{
                        System.out.println("Su contraseña no cumple la cantidad de caracteres");
                    }

                    if (letters && numbers){
                        System.out.println("Su contraseña es segura");
                        System.out.println("Ingrese un numero: ");
                        int c = 0; 
                        int num = sc.nextInt();
                        
                        char new_num = (char)num;
                        
                        for (int i = 0; i< pass.length(); i++)
                        {
                            if(c == 2){
                                new_pass += num;
                                c =0;
                                num++;
                            }
                            
                            new_pass += pass.charAt(i);
                            c++;
                            
                        }
                        
                        
                        
                        System.out.println("La nueva contraseña es: " + new_pass);
                        
                    }
                    else if(num_char && !letters){
                        System.out.println("Su contraseña no tiene letras");
                    }
                    else if(num_char && !numbers){
                        System.out.println("Su contraseña no tiene numeros");
                    }
                    
                    
                    
                    break;
                    
                case 3:
                    running = false;
                    break;
                    
                default:
                    break;
                    
                    
            }
        }
    }
    
}
