document.addEventListener('DOMContentLoaded', function() {
    console.log('로그인 페이지 로드 완료');

    // 서버에서 전달된 오류 메시지를 확인하고 alert로 표시
    if (typeof errorMessage !== 'undefined' && errorMessage) {
        alert(errorMessage);
    }
});