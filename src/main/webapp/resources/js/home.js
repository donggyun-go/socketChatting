function openSearchPopup() {
    var searchId = document.getElementById("searchId").value;
    var contextPath = '${pageContext.request.contextPath}';
    var popup = window.open(contextPath + '/home/chatting/searchFriendPopup.jsp?searchId=' + searchId, 'searchFriendPopup', 'width=600,height=400');
    return false;
}
