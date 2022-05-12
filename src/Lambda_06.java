import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda_06 {
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");

        Path cihan = Path.of("src/haluk.txt");  // path cihan objeya atandi
        Stream<String> akis = Files.lines(cihan);

        Files.lines(Paths.get("src/haluk.txt")).forEach(System.out::println);
        /* files class dan lines method call edilerek
        data cekilecek dosya yolu (path) parametre girilerek
        pathdeki dosyanin datalari akisa alindi.
         */
        akis.forEach(System.out::println);  // onceden hazir edilen method sadece yazdirildi


        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.lines(Paths.get("src/haluk.txt")).map(String::toUpperCase).forEach(System.out::println);


        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        // 1 yol
        Files.lines(cihan).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);

        // 2 yol find first
        System.out.println(Files.lines(cihan).
                map(String::toLowerCase).
                findFirst());

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");

        System.out.println(Files.lines(cihan).map(String::toLowerCase).filter(t -> t.contains("basari")).count());

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        /*
Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
 fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
  Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.

 */
        System.out.println(Files.lines(cihan).
                map(t -> t.split(" ")).     //  satirlarda ki kelemeler array'e atandi
                        flatMap(Arrays::stream).         //  to de arraydeki elemanlar tek eleman olarak akisa alindi
                        distinct().                     //   elemanlar tekrarsiz yapildi
                        collect(Collectors.toList())); //   ekisdaki  tekrarsiz elemanlar liste atandi

        // 2 yol
        System.out.println(Files.lines(cihan).
                map(t -> t.split(" ")).     //  satirlarda ki kelemeler array'e atandi
                        flatMap(Arrays::stream).         //  to de arraydeki elemanlar tek eleman olarak akisa alindi
                        collect(Collectors.toSet()));


        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");

        Files.lines(cihan).
                map(t -> t.split(" ")).     //  satirlarda ki kelemeler array'e atandi
                flatMap(Arrays::stream).
                sorted().
                forEach(System.out::println);      //  to de arraydeki elemanlar tek eleman olarak akisa alindi


        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(cihan).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.equals("basari")).
                count());

        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(cihan).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).        // her satirdaki her kelime akisa alindi
                        filter(t -> t.contains("a")). // a bulunduran kelimeler filtrelendi
                        count());

        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");

        System.out.println(Files.lines(cihan).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).        // her satirdaki her kelime akisa alindi
                        filter(t -> t.contains("a")). // a bulunduran kelimeler filtrelendi
                        collect(Collectors.toList()));

        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(cihan).
                map(t -> t.replaceAll("\\W", "").//satırlar \\W ifadesi a-z A-Z 0-9 _ disindakileri kapsar
                        replaceAll("\\d", "").
                        split("")).//harf akısı saglanır
                        flatMap(Arrays::stream).
                distinct().
                count());
              //  map(t -> t.replaceAll("\\W", "").replaceAll("\\d", "").split(" ")).
             //   flatMap(Arrays::stream).distinct().count());


        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

        System.out.println(Files.lines(cihan).
                map(t -> t.replaceAll("[.,:!\\-]", "").split(" ")).
                flatMap(Arrays::stream).distinct().count());


        //TASK 12 --> haluk.txt dosyasinda  farkli kelimeleri print ediniz
        System.out.println("\nTASK 12 --> haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        Files.lines(cihan).
                map(t -> t.replaceAll("[.!,:)\\-]", "").
                        split(" ")).//kelime akısı saglanır
                flatMap(Arrays::stream).
                distinct().forEach(System.out::println);
    }
}
