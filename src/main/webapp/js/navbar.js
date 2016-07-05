/**
 * Created by maverick on 16/1/2.
 */
function wantplus_navbar(){
    var want_navbar_home = document.createElement("span");
    want_navbar_home.className = "want-nav-home";
    want_navbar_home.innerText = "主页";
    want_navbar_home.id = "id_navbar_home";
    var want_navto_home = document.createElement("a");
    want_navto_home.className = "want-navstyle";
    want_navto_home.href = "index.html";
    want_navto_home.appendChild(want_navbar_home);

    var want_navbar_shop = document.createElement("span");
    want_navbar_shop.className = "want-nav-shop";
    want_navbar_shop.innerText = "商店";
    want_navbar_shop.id = "id_navbar_shop";
    var want_navto_shop = document.createElement("a");
    want_navto_shop.className = "want-navstyle";
    want_navto_shop.href = "classify.html";
    want_navto_shop.appendChild(want_navbar_shop);

    var want_navbar_featured = document.createElement("span");
    want_navbar_featured.className = "want-nav-featured";
    want_navbar_featured.innerText = "Featured";
    want_navbar_featured.id = "id_navbar_featured";
    var want_navto_featured = document.createElement("a");
    want_navto_featured.className = "want-navstyle";
    want_navto_featured.href = "featured.html";
    want_navto_featured.appendChild(want_navbar_featured);

    var want_navbar_sign = document.createElement("span");
    want_navbar_sign.className = "want-navlog want-sign-btn";
    want_navbar_sign.innerText = "注册";
    var want_navto_sign = document.createElement("a");
    want_navto_sign.className = "want-navstyle";
    want_navto_sign.appendChild(want_navbar_sign);

    var want_navto_login = document.createElement("a");
    want_navto_login.className = "want-navlog want-navright";
    want_navto_login.innerText = "登录";

    var want_navsearch = document.createElement("input");
    want_navsearch.className = "want-navsearch";
    want_navsearch.placeholder = "search";
    var want_search_inputicon = document.createElement("img");
    want_search_inputicon.className = "want-search-inputicon";
    want_search_inputicon.src = "/wantplus/icon/search.png";
    var want_search_inputbox = document.createElement("div");
    want_search_inputbox.className = "want-search-inputbox";
    want_search_inputbox.appendChild(want_search_inputicon);
    var want_search_outbox = document.createElement("div");
    want_search_outbox.className = "want-search-outbox";
    want_search_outbox.appendChild(want_navsearch);
    want_search_outbox.appendChild(want_search_inputbox);

    var want_navbar_width = document.createElement("div");
    want_navbar_width.className = "want-navbar-width";
    want_navbar_width.appendChild(want_navto_home);
    want_navbar_width.appendChild(want_navto_shop);
    //want_navbar_width.appendChild(want_navto_featured);
    want_navbar_width.appendChild(want_navbar_sign);
    want_navbar_width.appendChild(want_navto_login);
    //want_navbar_width.appendChild(want_search_outbox);

    var wantplusNavbar = document.getElementById("id_want_navbar");
    wantplusNavbar.appendChild(want_navbar_width);

    //var wantplusNavbar = document.getElementById("id_want_navbar");
    //var wantplusNavbar1 = document.getElementById("id_want_navbar1");
    //var wantplusTitle = document.title;
    //
    //if (wantplusTitle == 'details'){
    //    wantplusNavbar1.appendChild(want_navbar_width);
    //} else if (wantplusTitle == 'home') {
    //    wantplusNavbar.appendChild(want_navbar_width);
    //}





}

