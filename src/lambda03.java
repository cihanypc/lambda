import java.util.*;

public class lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "havucdilim", "buryan", "trilice",
                "yaglama", "kokorec", "arabasi", "guvec", "waffle", "trilice","cacix"));
        System.out.print("\n    ***      ");
        alfBykTekrarsiz(menu);
        System.out.print("\n    ***      ");
        chrsayisiterssirali(menu);
        System.out.print("\n    ***      ");
        chrsayaisiBuyuktenKucuge(menu);
        System.out.print("\n    ***      ");
        charKaresiCiftElSirala(menu);
        System.out.print("\n    ***      ");
        harfsayisikontrol(menu);
        System.out.print("\n    ***      ");
        wileBaslayanlarikontrol(menu);
        System.out.print("\n    ***      ");
        xileBaslayanlarikontrol(menu);
        System.out.print("\n    ***      ");
        karakterirnbuyukprint(menu);
        System.out.print("\n    ***      ");
        sonHarfeGoreSirala(menu);

    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrarsiz(List<String> yemek) {
        yemek.stream().
                // map(t -> t.toUpperCase()).  // elemanlar buyuk harf yapildi
                        map(String::toUpperCase).       // met. ref. ile harfler buyutuldu
                sorted().     // alfabetik siralama yaptirdi
                distinct().    //  benzersiz tekrarsiz hale getirdi
                forEach(t -> System.out.print(t + " "));

    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void chrsayisiterssirali(List<String> menu) {
        menu.stream().
                map(String::length).  //  elemanlar karakter sayisina update edildi
                sorted(Comparator.reverseOrder()). //  //
                distinct().        //
                forEach(Lambda01::yazdir);   //
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void chrsayaisiBuyuktenKucuge(List<String> menu) {
        menu.stream().
                sorted(Comparator.comparing(String::length)).forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonharfegoresirala(List<String> menu) {
        menu.stream().
                sorted(Comparator.comparing(t -> t.toString().
                        charAt(t.toString().length() - 1)).reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..

    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.stream().
                map(t -> t.length() * t.length()).   // string elemanlarin boyutlarinin karesi update edildi
                filter(Lambda01::ciftbul).distinct().  // tekrarsiz yapildi
                sorted(Comparator.reverseOrder()). // ters siralndi
                forEach(Lambda01::yazdir);
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfsayisikontrol(List<String> menu) {
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanlari 7 ve daha az harften olusuyor");

        } else System.out.println("list elemanlari 7 harften buyuk");
        System.out.println(kontrol);
//cincix
        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "list elemanlari 7 ve daha az harften olusuyor"
                : "list elemanlari 7 harften buyuk");
    }

    // Task : List elelmanlarinin "W" ile baslamas??n?? kontrol ediniz.

    public static void wileBaslayanlarikontrol(List<String> menu) {
        System.out.println(menu.stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek olur mu" : "w ile baslarmis yemekler");

    }


    // Task : List elelmanlarinin "x" ile biten en az bir elema?? kontrol ediniz.

    public static void xileBaslayanlarikontrol(List<String> menu) {
        System.out.println(menu.stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten yemek olur mu" : "x ile bitermis yemekler");

    }


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void karakterirnbuyukprint(List<String> menu) {

    menu.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).findFirst();
    // veriable assaign edilmis hali


    Optional<String > enbuyukkarakter = menu.stream().
            sorted(Comparator.comparing(t->t.toString().length()).
                    reversed()).findFirst();


    }

    // Task : list elemanlarini son harfine g??re siralay??p ilk eleman hari?? kalan elemanlari print ediniz.

    public static void sonHarfeGoreSirala(List<String> menu) {

        menu.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfe gore siralandi
                skip(1). // ilk eleman atlandi
                forEach(t-> System.out.println(t+" "));   // print

        //skip(1) => atlama demek. Ak??????n ilk n eleman??n?? att??ktan sonra
        // bu ak??????n kalan elemanlar??ndan olu??an bir ak???? return eder.
        // Bu ak???? n'den daha az ????e i??eriyorsa, bo?? bir ak???? d??nd??r??l??r.
        // Bu, durum bilgisi olan bir ara i??lemdir.
        //skip(list.size()-1) => List'in uzunlu??unun 1 eksi??ini yazarsak son eleman?? yazd??r??r??z.



        //limit(1) => S??n??rland??rma demek. Bu ak??????n elemanlar??ndan olu??an, uzunlu??u maxSize'dan uzun olmayacak
        // ??ekilde kesilmi?? bir ak???? return eder. Stream return eder.
        //limit(a) ak??sdan c??kan elemanlar?? a parametresine gore ilk a elaman?? al??r


        /*
  TR??CK : Stream'ler ekrana direk yazd??r??lamaz. Stream'i toArray() ile Array'e ??eviririz.
  Array'i de Arrays.toString() 'in i??ine al??p yazd??rabiliriz.
???  ??r; System.out.println(Arrays.toString(stream.toArray()));
veya System.out.println(Arrays.asList(***.toArray())); kullan??labilir.

   */
    }
}