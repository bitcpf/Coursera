complete <- function(directory, id = 1:332) {
    csvfiles <- sprintf("~/bitcpf/coursera_R/%s/%03d.csv",directory,id)
    nrows<- sapply(csvfiles,function(f) sum(complete.cases(read.csv(f))))
    rowlabels <- nrow(nrows)
    rv=data.frame(id,nobs=nrows,row.names=rowlabels)
    return(rv)
}
