// ==UserScript==
// @name         Payslip downloader: My first ever working TMonkey script
// @namespace    http://tampermonkey.net/
// @version      2025-06-09
// @description  try to take over the world!
// @author       pkoliwad-mdsol
// @match        https://mypayrollui.payrollengine.net/
// @icon         https://www.google.com/s2/favicons?sz=64&domain=payrollengine.net
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    // Your code here...

    window.onload = function(){
      console.log('Tampermonkey running monthly payslip download script============================')

      // let btnBook = document.getElementById('synopsis-book-button')
      // console.log(btnBook)
      // btnBook.click()

        setTimeout(() => {
            console.log('Inside timeout....');
            downloadPayslip();
        }, 3000);
    }

    function downloadPayslip() {
      // select year
      const yrModel =  $('[ng-model="selYear"]')[0];
      console.log(yrModel)

      let yearDropdown = angular.element(yrModel);
      console.log(yearDropdown);

      let scope = yearDropdown.scope() || yearDropdown.isolateScope();
      console.log('scope', scope);

      let currYear = parseInt(localStorage.getItem('currYr'));
      // yearDropdown.options.selectedIndex = currYear // 2010 if key not present
      scope.selYear = currYear.toString();
      // localStorage.setItem('currYr', currYear + 1);

      // select month
      // let monthDropdown = $('[ng-model="selMonth"]')[0]
      let currMonth = parseInt(localStorage.getItem('currMonth'));
      // monthDropdown.options.selectedIndex = currMonth
      scope.selMonth = currMonth.toString();
      // localStorage.setItem('currMonth', currMonth+1)

      console.log(currYear, currMonth);
      localStorage.setItem('currMonth', currMonth+1)


      if (currMonth > 12) {
        // doesn't always append year, you might need to reset manually in browser console
        localStorage.setItem('currYr', currYear + 1)
        localStorage.setItem('currMonth', 1)
      }


      // payslip option
        
      setTimeout(() => {
        let paySlipOption = $('[ng-click="showReports(EmployeeReport)"]')[0]
        paySlipOption.click()
      }, 3000);

      // download pdf btn
      setTimeout(() => {
        const downloadPdfBtn = $('[ng-click="downloadPDF()"]')[0]
        downloadPdfBtn.click()
      }, 4000)

      // home button: manually reload url instead of below home redirection
      // setTimeout(() => {
      //   let homeBtn = $('[ui-sref="app.home.dashboard"]')[0]
      //   homeBtn.click();
      // }, 7000)
    }
})();