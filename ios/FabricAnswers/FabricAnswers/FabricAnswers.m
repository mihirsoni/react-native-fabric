//
//  FabricAnswers.m
//  FabricAnswers
//
//  Created by Ravi Vagadia on 18/01/16.
//  Copyright © 2016 Ravi Vagadia. All rights reserved.
//

#import "FabricAnswers.h"

@implementation FabricAnswers

// The React Native bridge needs to know our module
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(logCustomEvent:(NSString *)mEventName details:(NSDictionary *)mArgs)
{
    NSLog(@"logCustomEvent: Method Called");
}

RCT_EXPORT_METHOD(logViewEvent: details:(NSDictionary *)mArgs)
{
    NSLog(@"logViewEvent: Method Called");
}

@end
