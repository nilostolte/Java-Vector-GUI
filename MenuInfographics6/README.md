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
propietary compact font format generated automatically by a tool I developed in JavaScript. Another tool uses this compact font, which contains 
Glyphs, their sizes and the respectives _"kerning pairs"_, to convert all Strings to Java `Path2D.Float` paths. Another font processed this way
is _MyriadPro-Bold_

