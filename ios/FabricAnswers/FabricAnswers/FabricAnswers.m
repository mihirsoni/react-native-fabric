//
//  FabricAnswers.m
//  FabricAnswers
//
//  Created by Ravi Vagadia on 18/01/16.
//  Copyright © 2016 Ravi Vagadia. All rights reserved.
//

#import "FabricAnswers.h"

#import <Fabric/Fabric.h>
#import <Crashlytics/Crashlytics.h>

@implementation FabricAnswers

// The React Native bridge needs to know our module
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(logCustomEvent:(NSString *)mEventName details:(NSDictionary *)mArgs)
{
    [Answers logCustomEventWithName:mEventName
                   customAttributes:mArgs];
    
    NSLog(@"logCustomEvent: logged");
}

RCT_EXPORT_METHOD(logViewEvent: details:(NSDictionary *)mArgs)
{
    [Answers logContentViewWithName:mArgs[@"contentName"]
                        contentType:mArgs[@"contentType"]
                          contentId:mArgs[@"contentId"]
                   customAttributes:@{}];
    NSLog(@"logViewEvent: logged");
}

@end
