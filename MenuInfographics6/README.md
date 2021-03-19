# MenuInfographics6

## Screenshot
![image](https://user-images.githubusercontent.com/80269251/111699875-0da90600-880f-11eb-8e8f-c15bf0abe534.png)

## Introduction

This is a complete Eclipse project showing an example of a **vector graphics** menu in Java that can be zoomed with the mouse wheel or with up and down 
keyboard keys. The items of the menu can be selected by clicking on them. Even though the window for the menu takes the whole screen, the transparent
background allows other applications to be selected and run while this application is running. Mouse clicks that concerns the menu or zooming
using the mouse wheel only work when the mouse is pointing inside one the items.

## Vector Menu Items

The menu items are represented by the same `Path2D.Float` _path_, which is the backbone of _Java_ `Shapes`,  that can be filled and stroked as any other
`Shape`. In this example the item is reproduced as many times as the number of items required for the menu (here it has five items). Only some details 
change, like the number of the item and its background color, the item title and description as well as the icons.

## Design

The design has been found in _Freepik_ but only the shape vector description has been used. It was converted to PostScript and converted
to Java with the tools I have developped for that. However, in this example, since it is not a very complex shape, this could also be developed 
by hand as most of the other elements that were only inspired in the original model and were all developed by hand. Gradients were modified to
give a metalic look.

## Icons

The stack icons were developed by hand in PostScript for its programming attributes (i.e. rotating items to make them seem to come out of the stack). Its
design was inspired from _StackOverflow_ icon. They were then converted to Java with tools I have developed to transform Postscript into Java.

The other icons were found on the web and they were all converted to Java using the same tools.

As usual, all the icons are also stored as `Path2D.Float` paths. `Path2D.Float` paths can be thought as low level portable representations of all
the GUI elements. That is the main idea behind developing GUIs using these paths. In reality, the whole GUI could be represented as data and changed
on the fly at will. These notions are explained in:

https://github.com/nilostolte/ClockWidget#clockwidget

## Vectorized Texts

All texts are vectorized and stored as `Path2D.Float` as well. They actually take most of the space of the whole program. The advantage is that they
have been generated automatically. The item numbers use the font _Confortaa-Bold_. This font is read with _Opentype.js_ and converted to a 
proprietary compact font format generated automatically by a tool I developed in JavaScript. Another tool uses this compact font, which contains 
Glyphs, their sizes and the respectives _"kerning pairs"_, to convert all Strings to Java `Path2D.Float` paths. Another font processed in this way
is _MyriadPro-Bold_, that was used for the items titles. These compact fonts are robust and enjoy the higher quality of PostScript fonts in
_Opentype_ files. The _kerning pairs_, in particular, are of much higher quality and more exaustive than in _Truetype_ fonts. Another advantage of 
PostScript fonts is that they are defined with cubic bezier curves which are much smoother and more compact than _Truetype_ quadratic bezier curves. 

The description of the items, which uses _MyriadPro-Regular_ font, is processed by a tool called _/BreakIntoLines_. The project 𝝅<i><b> Vector 
GUI for Android and Java</b></i>, where all these tools have been developed, was firstly developed as a _prototype_ in Postscript language. 
This is an on going project and some of the tools are still only coded in the prototype, and are not yet in their final form. One of these 
tools, _/BreakIntoLines_, is still coded in PostScript. It is a complex tool that breaks long texts into lines with right justification and 
kerning. The problem with the kerning in Postscript is that the kerning pairs are encoded and cannot be accessed. At this moment the kerning 
pairs are build by hand for each font, which is a very cumbersome task, something only valid for an experimental tool, which is what it really 
is. A more professional solution to this problem is either reading the kerning pairs from the _Opentype_ file and importing them into PostScript
or to rewrite _/BreakIntoLines_ alltogether. Obviously the latest solution is more desirable, since the text can be output as a path instead of
being displayed on the fly as it is currently done. In PostScript there is no difference between being displayed on the fly or to be transformed 
in path because the conversion can be done by intercepting the display commands. In Java that is not at all the case. For portability reasons,
one must be totally independent from any display command. Since text formatting is theoretically totally independent of display characteristics,
such as color, etc., because it is essentially only a question of scaling and translating Glyphs, this can be done with `Path2D.Float` paths,
which is the metalanguage defining all shapes in this project.

## Paths As A GUI Design Metalanguage

The common denominator in all elements of the this project is the use of paths (`Path2D.Float`, in Java) for their definition. As cited previously,
paths are what actually define `Shapes` in Java. In Java, `Shapes`, therefore also paths, can be displayed directly. Since paths are merely 
declarative static entities, they are actually only data, which share many similarities with PDF, although PDF has some programming
commands. This approach for designing and creating GUI is not something conceptually new, since it is the base of Quartz (https://en.wikipedia.org/wiki/Quartz_(graphics_layer)), which is what is behind the Core Graphics framework in Apple's macOS operating system. It is possible that the intrinsic vector graphics features in Java awt (path rendering, vector fonts, etc.) might be a part of NeWs (https://en.wikipedia.org/wiki/NeWS), a vector graphics Windowing System developed by Sun Microsystems, the same company that created Java (https://en.wikipedia.org/wiki/Java_(programming_language)). At least, _awt_ vector graphics have strong ressemblance to NeWs and to PostScript (https://en.wikipedia.org/wiki/PostScript).

The difference with the approach in this project is that Java vector graphics in _awt_ is a much higher level feature than Quartz, since it is dealt
at programming language level, not at operating system level. This opens the possibility of using this same abstraction in other programming
languages such as in C++. Please see the discussion at https://github.com/nilostolte/ClockWidget#vector-graphics-for-gui-programming.

