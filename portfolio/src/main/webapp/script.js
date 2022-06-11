// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Wow I cant find a flaw in his logic', 'What does the T on the wall stand for?', 'Dewey, get out of there that is not your family', 'The future is now, old man'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

// Get date and time
async function showServerDateTime() {
    const responseFromServer = await fetch('/dateTime');
    const textFromResponse = await responseFromServer.text();

    const dateContainer = document.getElementById('dateTime-container');
    dateContainer.innerText = textFromResponse;
}

async function showRandomFacts() {
    const responseFromServer = await fetch('/random');
    const textFromResponse = await responseFromServer.text();

    const factsContainer = document.getElementById('facts-container');
    factsContainer.innerText = textFromResponse;
}

