
function generateProvision(){

  document.getElementById('homepage').style.display='none';
  document.getElementById('provision-template').style.display='none';
  document.getElementById('characterForm').style.display='none';
  document.getElementById('transcriptform').style.display='none';
  document.getElementById('provisionForm').style.display='block';
}

function homePage(){

  document.getElementById('provisionForm').style.display='none';
  document.getElementById('characterForm').style.display='none';
  document.getElementById('provision-template').style.display='none';
  document.getElementById('transcriptform').style.display='none';
  document.getElementById('homepage').style.display='block';
}

function generateProvisionCertificate(){

  document.getElementById('provisionForm').style.display='none';
  document.getElementById('provision-template').style.display='block';
}
function generateCharacter(){

  document.getElementById('homepage').style.display='none';
  document.getElementById('provisionForm').style.display='none';
  document.getElementById('provision-template').style.display='none';
  document.getElementById('transcriptform').style.display='none';
  document.getElementById('characterForm').style.display='block';
}
function generateTranscript(){

  document.getElementById('homepage').style.display='none';
  document.getElementById('provisionForm').style.display='none';
  document.getElementById('provision-template').style.display='none';
  document.getElementById('characterForm').style.display='none';
  document.getElementById('transcriptform').style.display='block';
}