// ==UserScript==
// @name         Instagram unfollow script
// @namespace    http://tampermonkey.net/
// @version      2026-01-04
// @description  try to take over the world!
// @author       shronoa
// @match        https://www.instagram.com/*
// @icon         https://www.google.com/s2/favicons?sz=64&domain=instagram.com
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    // Your code here...
    window.onload = function(){
        console.log("TM running IG sanitisation script....");


        const currIndex = parseInt(localStorage.getItem('currentIndex'));
        const following_arr = localStorage.getItem('diff').split(",")
        const currUserName = following_arr[currIndex]

        if(currUserName) {
            console.log('found account...')
            if(localStorage.getItem('whitelisted_accs').includes(currUserName)) {
               console.log("Skipping", currUserName, "...");
               unfollowNext(following_arr[currIndex + 1], currIndex + 1);
            }else {
                //unfollow that account
                setTimeout(() => {
                    justDoIt(following_arr[currIndex + 1], currIndex + 1, currUserName)
                }, 2000)
            }
        }else if(currIndex == -1) {
            unfollowNext(following_arr[currIndex + 1], currIndex + 1);
        }else {
            alert('Account sanitization completed successfully!!!');
        }

        //unfollow that account
        //justDoIt(following_arr[currIndex + 1], currIndex + 1, currUserName)
    }

    function unfollowNext(nextUserName, nextIndex) {
        console.log('Inside unfollowNext');
        localStorage.setItem('currentIndex', nextIndex);
        window.location.href = `/${nextUserName}`;
    }

    function justDoIt(nextUserName, nextIndex, currentUserName) {
        // function to unfollow an account
        //
        const followingClassList = '._ap3a._aaco._aacw._aad6._aade';
        const followingDropdown = document.querySelector(followingClassList);
        if(followingDropdown){
            followingDropdown.click();

            // click unfollow button
            setTimeout(() => {
                //dig unfollow button
                const unfollowBtn = document.querySelector('[role="dialog"]').lastChild.lastChild.lastChild.lastChild.lastChild.lastChild
                unfollowBtn.click()
                console.log(`Unfollowed ${currentUserName}`)
            }, 2000);
        }else{
            console.error(`Account does not exist ${currentUserName}`);
            const deletedAccs = localStorage.deletedAccs || '';
            localStorage.deletedAccs = deletedAccs + ',' + currentUserName;
        }

        // unfollow next
        setTimeout(() => {
            unfollowNext(nextUserName, nextIndex);
        }, 4000);
    }
})();
