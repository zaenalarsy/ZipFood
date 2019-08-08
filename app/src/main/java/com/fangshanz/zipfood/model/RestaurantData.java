package com.fangshanz.zipfood.model;

import java.util.ArrayList;

public class RestaurantData {
    public static String[][] data = new String[][]{
            {"Mangkok Ku",
                    "Jl. Tanjung Duren Raya No. 359 C, Tanjung Duren, Jakarta",
                    "https://b.zmtcdn.com/data/reviews_photos/24c/d4a97a0ac1f17c29b184f9ff33be424c_1563966890.jpg?fit=around%7C800%3A887&crop=800%3A887%3B%2A%2C%2A",
                    "0812 11382132",
                    "Asia, Indonesia"},
            {"Pochajjang Korean BBQ",
                    "Jl. Gandaria I No. 20, Gandaria, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/chains/6/19047086/4fda0ffa22778f4050adff5f35e0adac.jpg?fit=around%7C800%3A782&crop=800%3A782%3B%2A%2C%2A",
                    "0878 86904001",
                    "Korea, Barbekyu"},
            {"Gyu - Kaku Japanese BBQ",
                    "AEON Mall, Lantai Ground, Jl. BSD Raya Utama, Serpong, Tangerang",
                    "https://b.zmtcdn.com/data/pictures/5/18266425/5bdee9f92897a61a1f6acb4eee023771.jpg?resize=1204%3A502&crop=1200%3A464%3B-3%2C9",
                    "021 29168102",
                    "Jepang, Barbekyu"},
            {"Yakiniku Kintan Buffet",
                    "Gandaria City, Lantai Upper Ground, Jl. Sultan Iskandar Muda, Gandaria, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/chains/1/18338211/52855a44b1b54e9570facc1b0d3a792a.jpg?resize=1215%3A508&crop=1200%3A464%3B8%2C23",
                    "021 22774785",
                    "Grill House, Jepang"},
            {"Union",
                    "Plaza Senayan, Lantai Ground, Jl. Asia Afrika, Senayan, Jakarta",
                    "https://b.zmtcdn.com/data/reviews_photos/b4c/eddec4103792d37071eb85481b1bfb4c_1522082291.jpg?resize=1203%3A1203&crop=1200%3A464%3B14%2C261",
                    "021 57905861",
                    "Itali, Amerika, Desserts"},
            {"Holywings",
                    "Jl. Gunawarman No. 44, Senopati, Jakarta",
                    "https://b.zmtcdn.com/data/res_imagery/7424759_CHAIN_fdddc3b97d415f9e1f6cad9d6c9bbd3a.jpg?fit=around%7C1200%3A464&crop=1200%3A464%3B0%2C0",
                    "0811 1071168",
                    "Asia"},
            {"Sushi Tei",
                    "Mall Kelapa Gading 5, Lantai 3, Jl. Kelapa Gading Boulevard, Kelapa Gading, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/chains/3/7400843/b91a8162708aac39647d6b59732361a6.jpg?resize=1214%3A506&crop=1200%3A464%3B4%2C7",
                    "021 45876410",
                    "Sushi, Ramen, Jepang"},
            {"Chatime",
                    "World Trade Center 2, Lantai Lower Ground, Jl. Jenderal Sudirman, Sudirman, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/3/18457023/0e0d659f2fab7593170e2215c83e8be3.jpg?resize=1204%3A1204&crop=1200%3A464%3B1%2C530",
                    "021 40184328",
                    "Minuman"},
            {"SaladStop!",
                    "Senayan City, Lantai Lower Ground, Jl. Asia Afrika, Senayan, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/chains/2/18385502/05899ffd7217d63e1b50e2c828d622a9.jpg?resize=1204%3A502&crop=1200%3A464%3B0%2C16",
                    "021 72781382",
                    "Makanan Sehat"},
            {"Osteria GIA",
                    "Pacific Place Mall, Lantai Ground, Jl. Jenderal Sudirman, SCBD, Jakarta",
                    "https://b.zmtcdn.com/data/pictures/7/19022727/b80e6ba6006ee9f303261f3525a20679.jpg?resize=1204%3A1204&crop=1200%3A464%3B-2%2C628",
                    "021 5153300",
                    "Itali"},
            {"Medja Restaurant",
                    "Jl. Pajajaran Indah V No. 6, Bogor Timur, Bogor",
                    "https://b.zmtcdn.com/data/pictures/chains/6/19093856/8448eeef4b423622fc19e30c11823e17.jpg?resize=1204%3A794&crop=1200%3A464%3B-3%2C172",
                    "0251 8385841",
                    "Indonesia"},
    };

    public static ArrayList<Restaurant> getListData(){
        ArrayList<Restaurant> list = new ArrayList<>();
        for (String[] aData: data) {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName(aData[0]);
            restaurant.setAddress(aData[1]);
            restaurant.setPhoto(aData[2]);
            restaurant.setPhoneNumber(aData[3]);
            restaurant.setFoodType(aData[4]);

            list.add(restaurant);
        }

        return list;
    }
}
