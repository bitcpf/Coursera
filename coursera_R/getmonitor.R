getmonitor <- function(id, directory, summarize = FALSE) {
            ## 'id' is a vector of length 1 indicating the monitor ID
            ## number. The user can specify 'id' as either an integer, a
            ## character, or a numeric.
            
            ## 'directory' is a character vector of length 1 indicating
            ## the location of the CSV files

            ## 'summarize' is a logical indicating whether a summary of
            ## the data should be printed to the console; the default is
            ## FALSE
            
            ## Your code here

    if(id>100){
        file<-paste(directory,id,sep="/")
    }
    else if (id>10) {
        idn<-paste("0",id,sep="")
        file<-paste(directory,idn,sep="/")
        
    }
    else{
        idn<-paste("00",id,sep="")
        file<-paste(directory,idn,sep="/")
    }
 
    file<-paste(file,".csv",sep="")
    data<-read.csv(file)

    if(summarize)
    {
        print(summary(data))
        #print(sumout)
    }
    return(data)
}
