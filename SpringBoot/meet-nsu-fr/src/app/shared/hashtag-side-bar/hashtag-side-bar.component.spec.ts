import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HashtagSideBarComponent } from './hashtag-side-bar.component';

describe('HashtagSideBarComponent', () => {
  let component: HashtagSideBarComponent;
  let fixture: ComponentFixture<HashtagSideBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HashtagSideBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HashtagSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
