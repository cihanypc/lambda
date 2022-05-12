import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftkareprint(sayi);  //
        System.out.println("\n     ***    ");
        tekkupbirfazlaprint(sayi); //
        System.out.println("\n     ***    ");
        ciftKarekokPrint(sayi);
        System.out.println("\n     ***    ");
        maxEl(sayi);
        System.out.println("\n     ***    ");
        ciftKareMaxbul(sayi);
        System.out.println("\n     ***    ");
        elTopla(sayi);
        System.out.println("\n     ***    ");
        ciftCarp(sayi);
        System.out.println("\n     ***    ");
        tekkarePrint(sayi);
        System.out.println("\n     ***    ");
        minBul(sayi);
        System.out.println("\n     ***    ");
        bestenbuyukenkucuk(sayi);
        System.out.println("\n     ***    ");

    }


    // Task : Functional Programming ile listin cift elemanlarinin
    // karelerini ayni satirda aralarina bosluk bırakarak print ediniz
    public static void ciftkareprint(List<Integer> sayi) {

        sayi.stream().filter(Lambda01::ciftbul).map(t -> t * t).forEach(Lambda01::yazdir);
        // map()  stream icindeki elemanlari baska tiplere donusturmek veya uzerlerinde islem yapmak icin kullanilir
    }

    // Task : Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz
    public static void tekkupbirfazlaprint(List<Integer> sayi) {
        sayi.stream(). // sayilar akisa alindi
                filter(t -> t % 2 != 0). // tek elemanlar filtrelendi
                map(t -> (t * t * t) + 1). // tek elemanlarin kupleri 1 artirildi
                forEach(Lambda01::yazdir);
    }
    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini
    // ayni satirda aralarina bosluk birakarak yazdiriniz
// Task : Functional Programming ile listin cift elemanlarinin
// karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftbul).map(Math::sqrt).forEach(t -> System.out.println(t + " "));

    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxEl(List<Integer> sayi) {

        Optional<Integer> maxsayi = sayi.stream().reduce(Math::max); // akisa giren leemanlarin action sonrasi tek eleman haline getirir.
        System.out.println(maxsayi);
        System.out.println("haliukca :" + sayi.stream().reduce(Math::max));
        /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde,
 bir önceki adımda elde edilen sonuç  bir sonraki adıma girdi olarak sunulmaktadır.
 Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxbul(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftbul).map(t -> t * t).reduce(Math::max));

    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        // method ref.

        int toplam = sayi.stream().reduce(0, (a, b) -> a + b); // lambda expression
        /*
        a ilk degerini her zamn atanan degerden (identy) alir
        b degerini her zamn stream dan alir
        a ilk degerinden sonra ki her degeri aksiyondan alir.
         */
        System.out.print(toplam);
        sayi.stream().reduce(Integer::sum);
        System.out.println(sayi.stream().reduce(Integer::sum));

    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftbul).reduce(Math::multiplyExact));

        System.out.println(sayi.stream().filter(Lambda01::ciftbul).reduce(1, (a, b) -> (a * b)));
    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    //1. yontem Method Reference --> Integer class
    //2. yontem Method Reference --> Math class
    //3. yontem Lambda Expression
    //4. yontem Method Reference --> Haluk class

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.




    public static void minBul(List<Integer> sayi) {
        //   1.yontem Method Reference --> Integer class
        Optional<Integer> minsayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println(minsayiInteger);

        // 2. yontem  Method Reference --> Math class
        Optional<Integer> minsayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minsayiMath);
        // 3 yontem Lambda Expression
        int minsayiLambda = (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minsayiLambda);
        // 4 yontem Method Reference --> Haluk class
        Optional<Integer> minsayiCihan = sayi.stream().reduce(Lambda02::byCihan);
        System.out.println(minsayiCihan);

        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.


    }

    public static int byCihan(int a, int b) {
        return a < b ? a : b;
    }

    public static void bestenbuyukenkucuk(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda02::byCihan));

    }

    public static void ciftKarebul(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftbul).map(t -> t * t).sorted().forEach(Lambda01::yazdir);
        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
//Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    public static void tekkarePrint(List<Integer> sayi) {
        sayi.stream().
                filter(t -> t% 2 == 1).
                map(t -> t * t).    // filtreleri tek karesi alindi
                sorted(Comparator.reverseOrder()).//  karesi alinan elemanlar ters siralandi
                forEach(Lambda01::yazdir);  // yazdirildi
    }

}