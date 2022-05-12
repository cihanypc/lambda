import java.util.stream.IntStream;

public class lambda_05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 --> amele " + toplaAmele(10));
        System.out.println("TASK 01 --> cincix " + toplacincix(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 --> " + toplacift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 --> " + toplaIlkXcift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 04 --> " + toplaIlkXtek(10));
        System.out.println("   ***   ");

        System.out.print("TASK 05 --> ");
        ikininIlkXkuvveti(7);
        System.out.println("   ***   ");

        System.out.println("TASK 06 --> ");
        istenenIlkXkuvveti(4, 3);
        istenenIlkXkuvveti(4, 5);
        istenenIlkXkuvveti(14531453, 0);
        System.out.println("   ***   ");

        System.out.println("TASK 07 --> " + istenenSayiFaktoriyel(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->" + istenenSayiXKuvveti(4,3));
        System.out.println("TASK 08 -->" + istenenSayiXKuvveti(3,4));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e
    // kadar tamsayilari toplayan bir program create ediniz.


    //Structured(AMELE) Programming
    public static int toplaAmele(int x) {
        int toplam = 0;
        for (int i = 1; i <= x; i++) {
            toplam += i;
        }
        return toplam;
    }


    //Functional(cincix Programming
    public static int toplacincix(int x) {
        return IntStream.
                range(1, x + 1).  // 1 den x'e kadar x dahil int degerler akisa alindi
                        sum(); // akistaki degerler toplandi
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplacift(int x) {
        return IntStream.
                rangeClosed(1, x).// 1 den x'e kadar x dahil int degerler akisa alindi
                        filter(Lambda01::ciftbul).  // cift degerler filtrelendi
                        sum(); // akistaki degerler toplandi
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaIlkXcift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).// 2 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).  // akisdaki ilk x int degerini alir
                        sum(); // akistaki degerler toplandi
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }


    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int toplaIlkXtek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).// 1 den sonsuza kadar elemanlari 2 artirarak akisa alir
                        limit(x).  // akisdaki ilk x int degerini alir
                        sum(); // akistaki degerler toplandi
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXkuvveti(int x) {
        IntStream.
                iterate(2, t -> t * 2).// 2 den sonsuza kadar elemanlari 2 ile carparak akisa alir
                limit(x).
                forEach(Lambda01::yazdir);
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }


    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenIlkXkuvveti(int istenensayi, int x) {
        IntStream.
                iterate(istenensayi, t -> t * istenensayi).// 2 den sonsuza kadar elemanlari 2 ile carparak akisa alir
                limit(x).
                forEach(Lambda01::yazdir);
        //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koy
    }


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenenSayiFaktoriyel(int x) {
        return IntStream.rangeClosed(1, x).
                // reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static int istenenSayiXKuvveti(int istenensayi, int x) {
        return IntStream.iterate(istenensayi,t->t*istenensayi).
                limit(x).reduce(0,(t,u)->u);

       // return Math.pow(istenensayi,x);
    }
}

