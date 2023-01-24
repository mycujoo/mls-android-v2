//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[AnimationClassifierHelper](index.md)

# AnimationClassifierHelper

[androidJvm]\
class [AnimationClassifierHelper](index.md)

Helper class to distinguish between animation types Each animation might be Static or Dynamic. Dynamic animations change their position as part of animation. either x, y or both might change during the animating phase. Static animations do NOT change their position at all. i.e. alpha might change. Animations can be valid for specific type, i.e. Fade-in animation is only valid for 'Intro' animation, and it is invalid for 'outro' animation.

## Constructors

| | |
|---|---|
| [AnimationClassifierHelper](-animation-classifier-helper.md) | [androidJvm]<br>fun [AnimationClassifierHelper](-animation-classifier-helper.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |
