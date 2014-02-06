corr <- function(directory, threshold = 0) {
            ## 'directory' is a character vector of length 1 indicating
            ## the location of the CSV files

            ## 'threshold' is a numeric vector of length 1 indicating the
            ## number of completely observed observations (on all
            ## variables) required to compute the correlation between
            ## nitrate and sulfate; the default is 0

            ## Return a numeric vector of correlations
    chelp <- function(fn,threshold){
        cdata=read.csv(paste(directory,"/",fn,sep=""))
        camt=sum(complete.cases(cdata))
        if(camt>threshold)
        {
            candata=cdata[complete.cases(cdata),]
            rvin=(cor(candata$sulfate,candata$nitrate))
            return(rvin)
        }
        #else
        #{
        #    return(numeric())
        #}
    }
    
    rv=numeric()
    filenames=list.files(directory)
    for(fn in filenames)
    {
        rv=c(rv,chelp(fn,threshold))
    }
    return(rv)

}
