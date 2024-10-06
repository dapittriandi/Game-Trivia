package com.mobiledev.myrecyclerview;

import java.util.ArrayList;

public class DataLokasi {
    public static String[][] data = new String[][] {
            {
                    "Lokasi 1",
                    "Green Mountain",
                    "https://fastly.picsum.photos/id/28/4928/3264.jpg?hmac=GnYF-RnBUg44PFfU5pcw_Qs0ReOyStdnZ8MtQWJqTfA",
                    "Green Mountain Energy was founded in Vermont in 1997 as an " +
                            "offshoot of Green Mountain Power to take advantage of the deregulation of the Texas electricity market." +
                            " In September 2000, the company moved its headquarters to Austin, Texas. In January 2002, Green Mountain began serving the Texas market and was the first to offer alternative energy in the state." +
                            " In August 2009 Green Mountain Energy expanded to New York City, serving those in the Con Edison service territory."
            }, {
            "Lokasi 2",
            "Nevada",
            "https://fastly.picsum.photos/id/29/4000/2670.jpg?hmac=rCbRAl24FzrSzwlR5tL-Aqzyu5tX_PA95VJtnUXegGU",
            "Nevada is officially known as the \"Silver State\" because of the importance of " +
                    "silver to its history and economy. It is also known as the \"Battle Born State\" because it achieved statehood during the Civil War (the words \"Battle Born\" also appear on its state flag); " +
                    "due to the presidency of Abraham Lincoln, the Union benefited immensely from the support of newly awarded statehood by the infusion of the monetary support of " +
                    "nearly $400 million in silver ore generated at the time by the Comstock Lode"
            }, {
                    "Lokasi 3",
                    "California sea",
                    "https://fastly.picsum.photos/id/27/3264/1836.jpg?hmac=p3BVIgKKQpHhfGRRCbsi2MCAzw8mWBCayBsKxxtWO8g",
                    "The Salton Sea is a shallow, landlocked, highly saline body of water in " +
                            "Riverside and Imperial counties at the southern end of the U.S. state of California. " +
                            "It lies on the San Andreas Fault within the Salton Trough, which stretches to the Gulf of California in Mexico"
            }, {
                    "Lokasi 4",
                    "Canada",
                    "https://fastly.picsum.photos/id/17/2500/1667.jpg?hmac=HD-JrnNUZjFiP2UZQvWcKrgLoC_pc_ouUSWv8kHsJJY",
                    "Canada is a country in North America. Its ten provinces and three territories extend " +
                            "from the Atlantic Ocean to the Pacific Ocean and northward into the Arctic Ocean, making it the world's second-largest country by total area, with the world's longest coastline"
            }, {
                    "Lokasi 5",
                    "Antartika",
                    "https://fastly.picsum.photos/id/16/2500/1667.jpg?hmac=uAkZwYc5phCRNFTrV_prJ_0rP0EdwJaZ4ctje2bY7aE",
                    "Antarctica, the southernmost continent and site of the South Pole, " +
                            "is a virtually uninhabited, ice-covered landmass. Most cruises to the continent visit the Antarctic Peninsula, " +
                            "which stretches toward South America. It’s known for the Lemaire Channel and Paradise Harbor, " +
                            "striking, iceberg-flanked passageways, and Port Lockroy, a former British research station turned museum. The peninsula’s isolated terrain also shelters rich wildlife, including many penguins. "
            }, {
                    "Lokasi 6",
                    "London",
                    "https://fastly.picsum.photos/id/43/1280/831.jpg?hmac=glK-rQ0ppFClW-lvjk9FqEWKog07XkOxJf6Xg_cU9LI",
                    "Several bridges named London Bridge have spanned the River Thames between the City " +
                            "of London and Southwark, in central London. It is the oldest road-crossing location on the river, " +
                            "and from ancient times until the 1720s was the only bridge on The Thames."
            },
    };

    public static ArrayList<Lokasi> getListData() {
        Lokasi lokasi = null;
        ArrayList<Lokasi> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            lokasi = new Lokasi();
            lokasi.setLokasi(data[i][0]);
            lokasi.setNama(data[i][1]);
            lokasi.setImg(data[i][2]);
            lokasi.setDesc(data[i][3]);

            list.add(lokasi);
        }
        return list;
    }
}
