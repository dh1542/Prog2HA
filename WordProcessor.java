public class WordProcessor  extends Thread {

    int limit;
    int offset;



    public WordProcessor(int offset, int limit){

        this.limit = limit;
        this.offset = offset;


    }

    public int getLimit() {
        int arrayl = Data.words.length;
        int out = limit;
        if(out < 0){
            out = Math.abs(out);
            if(out > arrayl){
                out = arrayl;
            }

            return out;





        }
        else if(limit > arrayl){
            this.limit = arrayl;

        }
        else if(limit < arrayl){
            return limit;
        }


        return this.limit;
    }

    public int getOffset() {
        int arrayl = Data.words.length;



        if(offset < 0){
            int off = Math.abs(offset);

            if(off >= arrayl){
                if(off > 2* arrayl){
                    while(off > 2* arrayl){
                        off = off- arrayl;

                    }

                }
                off = Math.abs(arrayl - off);
                System.out.println(off);


                if(off >= limit){
                    off = 0;
                }
                this.offset = off;
                System.out.println(off);
            }
            this.offset = Math.abs(offset);
        }
        else if(offset >= arrayl){
            int off = Math.abs(arrayl - offset);
            this.offset = off;
        }
        else if(offset >= getLimit()){
            this.offset= offset- Data.words.length;


        }

        return offset;


    }

    @Override public void run()
    {
        synchronized (this){

            System.out.println("Offset: " + getOffset());
            System.out.println("Limit: " + getLimit());



            int counter = getOffset();


            while(counter <= getLimit()){
                if(counter == Data.words.length){

                    break;


                }
                String word = Data.words[counter ];
                word = word.toLowerCase();
                word = Data.rightPad(word, 12, "0");
                System.out.println(counter + ":   " + word);

                counter ++;


            }
        }

    }










    // TODO: implement me
}
