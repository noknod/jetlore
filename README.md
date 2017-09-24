# jetlore
Test task for Jetlore

We are building a social newsreader. There will be 3 modules:

1) The first module will crawl the Facebook and Twitter feeds.

2) The second module will extract important concepts from the feed. i.e. entities, links or twitter
usernames. (In the example below, you can see how there is an entity from position 14 through
22, another entity from position 0 to 5 and so on).

3) The third module will format each post as follows:
● Entities should be wrapped in "strong" tags
● Links should be wrapped in "a href" tags that point to the corresponding links
● Twitter usernames should be wrapped in "a href" tags that point to
"http://twitter.com/username" and are displayed as the username

Please write the code for the ​third module ​that takes the output from the second module and
the first module as an input, and produces formatted text.

This is a code design question, so we are looking for strong OOD principles. Think about what
data structures, objects and classes that you want to use to structure/define your input.
What is the best code design to prevent others from making mistakes when using your code?
If somebody was to extend your code with new types like "hashtags" (that would be decorated
with another HTML tag): how complex/error prone would it be?

Please submit your code in a language of your choice, Scala or Java strongly preferred.

Example

Module One Output:
“Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile”

Module Two Output ​ (in an appropriate object of your choosing):
positions 14 through 22 → Entity
positions 0 through 5 → Entity
positions 55 through 67 → Twitter username
positions 37 through 54 → Link

Module Three Output (takes as input the outputs of modules 1 and 2):
<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a
href=”http://bit.ly/xyz”>http://bit.ly/xyz </a> @ <a
href=”http://twitter.com/elversatile”>elversatile</a>
