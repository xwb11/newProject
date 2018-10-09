function gerTrim(element) {
    return element ==null ? '' : element.replace(/(^\s*)|(\s*$)/g, "");;
}

function getTimestamp(){
    // return new Date().getTime();
    console.log(new Date().getTime());
}