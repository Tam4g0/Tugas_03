public class Kereta {
    private String namaKereta;
    private int sisaTicket;
    private Ticket ticket;
    //Overload Constructor 1
    public Kereta() { //Constructor Kereta Komuter
        this.namaKereta = "Komuter";
        this.sisaTicket = 1000;
        this.ticket = new Ticket();
    }
    //Overload Constructor 2
    public Kereta(String namaKereta, int sisaTicket) { //Constructor Kereta Jarak Jauh
       this.namaKereta = namaKereta;
       this.sisaTicket = sisaTicket;
       this.ticket = new Ticket(namaKereta, sisaTicket);
    }
    //Overload Method 1
    public void tambahTiket(String namaPenumpang) { //Method Tambah Tiket Kereta Komuter
        String[] nama = new String[ticket.getNamaPenumpang().length + 1];
        System.arraycopy(ticket.getNamaPenumpang(), 0, nama, 0, ticket.getNamaPenumpang().length);
        nama[ticket.getNamaPenumpang().length] = namaPenumpang;
        ticket.setNamaPenumpang(nama);
    
        System.out.println("===========================");
        System.out.println("Berhasil dipesan");
    }
    //Overload Method 2
    public void tambahTiket(String namaPenumpang, String asal1, String tujuan1) { //Method Tambah Tiket Kereta Jarak Jauh
        if (ticket.getNamaPenumpang().length < sisaTicket) { //Percabangan ketika masih tersedia
            String[] nama = new String[ticket.getNamaPenumpang().length + 1];
            String[] asal = new String[ticket.getAsal().length + 1];
            String[] tujuan = new String[ticket.getTujuan().length + 1];
    
            System.arraycopy(ticket.getNamaPenumpang(), 0, nama, 0, ticket.getNamaPenumpang().length);
            System.arraycopy(ticket.getAsal(), 0, asal, 0, ticket.getAsal().length);
            System.arraycopy(ticket.getTujuan(), 0, tujuan, 0, ticket.getTujuan().length);
            
            nama[ticket.getNamaPenumpang().length] = namaPenumpang;
            asal[ticket.getAsal().length] = asal1;
            tujuan[ticket.getTujuan().length] = tujuan1;
    
            ticket.setNamaPenumpang(nama);
            ticket.setAsal(asal);
            ticket.setTujuan(tujuan);
    
            if (sisaTicket - ticket.getNamaPenumpang().length < 30) { //percabangan untuk menampilkan sisa tiket ketika tersisa 30 buah
                System.out.println("====================");
                System.out.println("Tiket berhasil di pesan. Sisa tiket tersedia : " + (sisaTicket - ticket.getNamaPenumpang().length));
            } else { //percabangan apabila tiket  sudah penuh
                System.out.println("=======================");
                System.out.println("Tiket gagal di pesan");
            }
    
        } else { //percabangan apabila tiket telah habis terjual
            System.out.println("=========================");
            System.out.println("Kereta telah habis dipesan, silahkan cari keberangkatan lain.");
        }
    }
    
    
    public void tampilkanTiket() { // Method untuk menampilkan outputan  data tiket yang sudah dibuat
        System.out.println("==================================");
        System.out.println("Daftar penumpang kereta api " + this.namaKereta + ": ");
        System.out.println("--------------------------------");

        for (int i = 0; i < ticket.getNamaPenumpang().length; i++) {
            if (this.namaKereta.equals("Komuter")) {
                System.out.println("Nama : " + this.ticket.getNamaPenumpang()[i]);
            } else {
                System.out.println("Nama : " + this.ticket.getNamaPenumpang()[i]);
                System.out.println("Asal : " + this.ticket.getAsal()[i]);
                System.out.println("Tujuan : " + this.ticket.getTujuan()[i]);
                System.out.println("-----------------------------------");
            }
        } 
    }

    

 
}
