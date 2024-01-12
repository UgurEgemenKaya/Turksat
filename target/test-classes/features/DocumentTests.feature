
Feature: Belge olusturma
  Background:

    Given Authorized user has logged in.

    @Turksat
    Scenario: User creates a document via Evrak Isleri tab
      When User clicks on Evrak Isleri at Home Page
      And Fills out all necessary fields in Bilgileri tab
      And Switches in to Editor tab
      And Fills all necessary fields in Editor tab
      And Switches in to Ekler tab
      And Adds new attachment
      And Signs the document with S imza
      Then Checks for the document in the Imzaladiklarim and Teslim alinmayi bekleyenler

    @TurksatSecondScenario
    Scenario Outline: User checks areas in the Bilgileri tab
      When User clicks on Evrak Isleri at Home Page
      Then checks all the required "<areas>" exists
      Examples:
      |  areas                  |
      |  Konu Kodu              |
      |  Konu                   |
      |  Kaldırılacak Klasörler |
      |  Evrak Türü             |
      |  Kayıt Tarihi           |
      |  Evrak Dili	            |
      |  Gizlilik Derecesi      |
      |  Kanun Kapsam Tipi      |
      |  Evrak Sayı Ek Metni    |
      |  İvedilik               |
      |  Miat                   |
      |  Bilgi Seçim Tipi	    |
      |  Bilgi                  |
      |  Gereği Seçim Tipi	    |
      |  Gereği                 |
      |  Dağıtımı Ek Yap	    |
      |  Dağıtım Listesi Yap    |
      |  Onay Akışı	            |

