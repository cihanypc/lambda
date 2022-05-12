import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 66, 64, 81, 38, 15));
        printElstructured(sayi);

        printElfunctional(sayi);

        System.out.print("\n     ****   ");
        printElfunctional1(sayi);
        System.out.print("\n     ****   ");
        printciftElStuctured(sayi);
        System.out.print("\n     ****   ");
        printciftElStuctured2(sayi);
        System.out.print("\n     ****   ");
        printciftElStuctured3(sayi);
        System.out.print("\n     ****   ");
        print34buyukciftElStuctured(sayi);

    }

    // task : structured programing kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void printElstructured(List<Integer> sayi) {
        for (Integer w : sayi
        ) {
            System.out.print(w + " ");
        }
    }

    // task : functional programing kullanarak list elemanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void printElfunctional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));

        /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */

    }

    public static void printElfunctional1(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print); // method referance ayni satira ve bosluk birakmaz
    }

    public static void yazdir(int a) { // yazdirma islemi yapan seed (tohum) method create edildi
        System.out.println(a + " ");
    }

    public static void printElfunctional2(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir); // method referance
    }

    // task : structured programing kullanarak list elemanlarini cift olanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz

    public static void printciftElStuctured(List<Integer> sayi) {
        for (Integer w : sayi
        ) {
            if (w % 2 == 0) {
                System.out.println(w + " ");
            }
        }
    }
    // task : functional programing kullanarak list elemanlarini cift olanlarini ayni satirda aralarinda bosluk olacak sekilde print ediniz

    public static void printciftElStuctured1(List<Integer> sayi) {

        sayi.stream().filter(t -> t % 2 == 0).forEach(Lambda01::yazdir);
    }

    public static boolean ciftbul(int a) { // kendisine verilen unt degerin cift olmasini kontrol eder
        return a % 2 == 0;
    }

    public static void printciftElStuctured2(List<Integer> sayi) {
        sayi.stream().  // list elemanlari akisa alindi
                filter(Lambda01::ciftbul). // cift bul methodu referre edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01::yazdir); // filtreden gelen elemanlar print edildi
    }
    // task : functional programing kullanarak list elemanlarini  34 ten kucuk cift olanlarini  ayni satirda aralarinda bosluk olacak sekilde print ediniz

    public static void printciftElStuctured3(List<Integer> sayi) {

        sayi.stream().filter(t -> t % 2 == 0 && t < 34).forEach(Lambda01::yazdir);
    }

    // task : functional programing kullanarak list elemanlarini  34 ten buyuk veya  cift olanlarini  ayni satirda aralarinda bosluk olacak sekilde print ediniz
    public static void print34buyukciftElStuctured(List<Integer> sayi) {

        sayi.stream().filter(Lambda01::ciftbul).filter(t -> t > 34).forEach(Lambda01::yazdir);
    }

}
