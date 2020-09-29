function replace_search(name, value) {
    var str = location.search;
    if (new RegExp("[&?]"+name+"([=&].+)?$").test(str)) {
        str = str.replace(new RegExp("(?:[&?])"+name+"[^&]*", "g"), "")
    }
    str += "&";
    str += name + "=" + value;
    str = "?" + str.slice(1);
    // there is an official order for the query and the hash if you didn't know.
    location.assign(location.origin + location.pathname + str + location.hash)
};